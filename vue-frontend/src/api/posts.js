import { posts } from './index';

function fetchPosts() {
    return posts.get('/');
}

function createPosts(postData) {
    return posts.post('/', postData);
}

export { fetchPosts, createPosts };