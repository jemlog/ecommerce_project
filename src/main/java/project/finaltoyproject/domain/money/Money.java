package project.finaltoyproject.domain.money;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;


public class Money {

    public static final Money ZERO = Money.wons(0);

    // 돈을 나타낼때는 BigDecimal을 사용하자
    private final BigDecimal amount;

    // long 형으로 들어오든
    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    // double 형으로 들어오든 BigDecimal 형태로 변환!
    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    // TODO : 해석해보기
    public static <T> Money sum(Collection<T> bags, Function<T, Money> monetary) {
        return bags.stream().map(bag -> monetary.apply(bag)).reduce(Money.ZERO, Money::plus);
    }

    Money(BigDecimal amount) {
        this.amount = amount;
    }

    // BigDecimal을 사용하면 사칙연산 사용 가능!
    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }

    public Money minus(Money amount) {
        return new Money(this.amount.subtract(amount.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public Money divide(double divisor) {
        return new Money(amount.divide(BigDecimal.valueOf(divisor)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long longValue() {
        return amount.longValue();
    }

    public Double doubleValue() {
        return amount.doubleValue();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Money)) {
            return false;
        }

        Money other = (Money)object;
        return Objects.equals(amount.doubleValue(), other.amount.doubleValue());
    }

    public int hashCode() {
        return Objects.hashCode(amount);
    }

    public String toString() {
        return amount.toString() + "원";
    }
}
