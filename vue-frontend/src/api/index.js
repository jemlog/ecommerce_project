import axios from 'axios';
import { setInterceptors } from './common/interceptors';

function createAxiosService() {
    return axios.create({
        baseURL: 'http://localhost:8083',
    });
}

function createAxiosServiceWithAuth(url) {
    const axiosService = axios.create({
        baseURL: `http://localhost:8083/${url}`,
    });

    return setInterceptors(axiosService);
}

export const axiosService = createAxiosService();
export const posts = createAxiosServiceWithAuth('posts');
