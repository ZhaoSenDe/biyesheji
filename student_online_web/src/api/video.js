import {post} from "./request";

export function listVideo(data) {
    return post('api/study/videoTotal/list',data)

}
export function savaVideo(data) {
    return post('api/study/videoTotal/save   ',data)

}
export function deleteVideos(data) {
    return post('api/study/videoTotal/delete  ',data)

}