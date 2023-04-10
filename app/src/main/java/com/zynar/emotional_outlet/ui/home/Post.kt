package com.zynar.emotional_outlet.ui.home

import com.google.gson.annotations.SerializedName

class Post {
    @SerializedName("post_number")
    var postNumber: Int = 0 // 게시글 번호
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
    var likeCount: Int = 0  // 좋아요 숫자
    @SerializedName("reply_count")
    var replyCount: Int = 0 // 댓글 숫자
}