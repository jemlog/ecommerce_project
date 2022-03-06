import { axiosService } from './index';

function registerUser(userData) {
    return axiosService.post('auth/signup', userData);
}

function loginUser(userData) {
    return axiosService.post('auth/login', userData);
}

export { registerUser, loginUser };