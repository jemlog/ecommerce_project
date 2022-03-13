import axios from 'axios';
import { setInterceptors } from './common/interceptors';

function createAxiosService() {
    return axios.create({

    });
}

function createAxiosServiceWithAuth(url) {
    const axiosService = axios.create({
        baseURL: `${url}`,
    });

    return setInterceptors(axiosService);
}
function createAxiosServiceWithAuthAndSendMultiPart(url) {
    const axiosService = axios.create({
        baseURL: `${url}`,
        headers :{
            'Content-Type': 'multipart/form-data'
        }
    });

    return setInterceptors(axiosService);
}

export const axiosService = createAxiosService();
export const posts = createAxiosServiceWithAuth('items');
export const postsWithMultiPart = createAxiosServiceWithAuthAndSendMultiPart('items')
export const orders = createAxiosServiceWithAuth('orders');
export const profile = createAxiosServiceWithAuth('api/user/profile');
