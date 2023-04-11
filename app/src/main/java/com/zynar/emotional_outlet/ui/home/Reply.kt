package com.zynar.emotional_outlet.ui.home

import com.google.gson.annotations.SerializedName

class Reply {
    @SerializedName("reply_number")
    var replyNumber: Int = 0 // 댓글 번호
    @SerializedName("parent_post_number")
    var parentPostNumber: Int = 0   // 게시글 번호
    @SerializedName("parent_reply_number")
    var parentReplyNumber: Int = 0  // 상위 댓글 번호
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
    var likeCount: Int = 0  // 좋아요 숫자
    @SerializedName("nested_reply_count")
    var replyCount: Int = 0 // 대댓글 숫자
    @SerializedName("is_deleted")
    var isDeleted: Boolean = false // 삭제 플래그



}