import { axiosService } from './index';

function registerUser(userData) {
    return axiosService.post('api/signup', userData);
}

function loginUser(userData) {
    return axiosService.post('api/authenticate', userData);
}

export { registerUser, loginUser };