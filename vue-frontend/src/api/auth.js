import {axiosService, profile} from './index';

function registerUser(userData) {
    return axiosService.post('api/signup', userData);
}




function loginUser(userData) {
    return axiosService.post('api/authenticate', userData);
}

function getProfile(userId)
{
    return profile.get(`/${userId}`);
}


export { registerUser, loginUser,getProfile };