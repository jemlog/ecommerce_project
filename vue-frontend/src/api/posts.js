import { posts } from './index';

function fetchPosts() {
    return posts.get('/');
}

function createPosts(itemData) {
    return posts.post('/', itemData);
}

function deletePosts(itemId) {
    return posts.delete(`/${itemId}`);
}


export { fetchPosts, createPosts , deletePosts};