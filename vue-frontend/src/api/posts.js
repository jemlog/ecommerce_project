import {posts, postsWithMultiPart} from './index';

function fetchPosts() {
    return posts.get('/');
}

function createPosts(itemData) {
    return postsWithMultiPart.post('/', itemData);
}

function deletePosts(itemId) {
    return posts.delete(`/${itemId}`);
}


export { fetchPosts, createPosts , deletePosts};