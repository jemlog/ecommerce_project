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

export const axiosService = createAxiosService();
export const posts = createAxiosServiceWithAuth('items');
