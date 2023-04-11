package com.zynar.emotional_outlet.ui.home

import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("number")
    var number: Int = 0 // 게시글 번호
    @SerializedName("user_uid")
    var userUID: String = ""   // 유저 uid
    @SerializedName("user_nickname")
    var userNickname: String = ""   // 유저 닉네임
    @SerializedName("user_tag")
    var userTag: String = ""    // 유저 태그
    @SerializedName("content")
    var content: String = ""    // 내용
    @SerializedName("upload_date")
    var uploadDate: String = "" // 업로드 날짜
    @SerializedName("update_date")
    var updateDate: String = "" // 수정 날짜
    @SerializedName("like_count")
    var likeCount: String = ""  // 좋아요 개수
    @SerializedName("reply_count")
    var replyCount: Int = 0 // 댓글 개수
    @SerializedName("is_deleted")
    var isDeleted: Int = 0 // 삭제 플래그
    @SerializedName("post_type")
    var type: Int = 0 // 게시글 타입
    @SerializedName("is_anonymous")
    var isAnonymous: Int = 0 // 익명

}