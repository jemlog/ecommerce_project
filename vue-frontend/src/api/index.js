import axios from "axios";

function registerUser(userData){

    const url = '/auth/signup';
    return axios.post(url,userData);
}

export {registerUser};