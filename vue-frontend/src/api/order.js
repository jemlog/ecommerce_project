import {orders} from "@/api/index";

function fetchOrders() {
    return orders.get('/');
}

function createOrders(orderData) {
    return orders.post('/', orderData);
}

function deleteOrders(orderId) {
    return orders.delete(`/${orderId}`);
}


export { fetchOrders, createOrders , deleteOrders};