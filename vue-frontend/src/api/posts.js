import { posts } from './index';

function fetchPosts() {
    return posts.get('/');
}

function createPosts(itemData) {
    return posts.post('/', itemData);
}



export { fetchPosts, createPosts };