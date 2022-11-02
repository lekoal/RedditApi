package com.private_projects.redditapi.data


import com.google.gson.annotations.SerializedName

data class RedditData(
    val `data`: Data,
    val kind: String
) {
    data class Data(
        val after: String,
        val before: Any?,
        val children: List<Children>,
        val dist: Int,
        @SerializedName("geo_filter")
        val geoFilter: Any?,
        val modhash: String
    ) {
        data class Children(
            val `data`: Data,
            val kind: String
        ) {
            data class Data(
                @SerializedName("all_awardings")
                val allAwardings: List<AllAwarding>,
                @SerializedName("allow_live_comments")
                val allowLiveComments: Boolean,
                @SerializedName("approved_at_utc")
                val approvedAtUtc: Any?,
                @SerializedName("approved_by")
                val approvedBy: Any?,
                val archived: Boolean,
                val author: String,
                @SerializedName("author_flair_background_color")
                val authorFlairBackgroundColor: String?,
                @SerializedName("author_flair_css_class")
                val authorFlairCssClass: String?,
                @SerializedName("author_flair_richtext")
                val authorFlairRichtext: List<AuthorFlairRichtext>,
                @SerializedName("author_flair_template_id")
                val authorFlairTemplateId: String?,
                @SerializedName("author_flair_text")
                val authorFlairText: String?,
                @SerializedName("author_flair_text_color")
                val authorFlairTextColor: String?,
                @SerializedName("author_flair_type")
                val authorFlairType: String,
                @SerializedName("author_fullname")
                val authorFullname: String,
                @SerializedName("author_is_blocked")
                val authorIsBlocked: Boolean,
                @SerializedName("author_patreon_flair")
                val authorPatreonFlair: Boolean,
                @SerializedName("author_premium")
                val authorPremium: Boolean,
                val awarders: List<Any>,
                @SerializedName("banned_at_utc")
                val bannedAtUtc: Any?,
                @SerializedName("banned_by")
                val bannedBy: Any?,
                @SerializedName("can_gild")
                val canGild: Boolean,
                @SerializedName("can_mod_post")
                val canModPost: Boolean,
                val category: Any?,
                val clicked: Boolean,
                @SerializedName("content_categories")
                val contentCategories: Any?,
                @SerializedName("contest_mode")
                val contestMode: Boolean,
                val created: Double,
                @SerializedName("created_utc")
                val createdUtc: Double,
                @SerializedName("discussion_type")
                val discussionType: Any?,
                val distinguished: String?,
                val domain: String,
                val downs: Int,
                val edited: Boolean,
                val gilded: Int,
                val gildings: Gildings?,
                val hidden: Boolean,
                @SerializedName("hide_score")
                val hideScore: Boolean,
                val id: String,
                @SerializedName("is_created_from_ads_ui")
                val isCreatedFromAdsUi: Boolean,
                @SerializedName("is_crosspostable")
                val isCrosspostable: Boolean,
                @SerializedName("is_meta")
                val isMeta: Boolean,
                @SerializedName("is_original_content")
                val isOriginalContent: Boolean,
                @SerializedName("is_reddit_media_domain")
                val isRedditMediaDomain: Boolean,
                @SerializedName("is_robot_indexable")
                val isRobotIndexable: Boolean,
                @SerializedName("is_self")
                val isSelf: Boolean,
                @SerializedName("is_video")
                val isVideo: Boolean,
                val likes: Any?,
                @SerializedName("link_flair_background_color")
                val linkFlairBackgroundColor: String,
                @SerializedName("link_flair_css_class")
                val linkFlairCssClass: String?,
                @SerializedName("link_flair_richtext")
                val linkFlairRichtext: List<LinkFlairRichtext>,
                @SerializedName("link_flair_template_id")
                val linkFlairTemplateId: String?,
                @SerializedName("link_flair_text")
                val linkFlairText: String?,
                @SerializedName("link_flair_text_color")
                val linkFlairTextColor: String,
                @SerializedName("link_flair_type")
                val linkFlairType: String,
                val locked: Boolean,
                val media: Media?,
                @SerializedName("media_embed")
                val mediaEmbed: MediaEmbed?,
                @SerializedName("media_only")
                val mediaOnly: Boolean,
                @SerializedName("mod_note")
                val modNote: Any?,
                @SerializedName("mod_reason_by")
                val modReasonBy: Any?,
                @SerializedName("mod_reason_title")
                val modReasonTitle: Any?,
                @SerializedName("mod_reports")
                val modReports: List<Any>,
                val name: String,
                @SerializedName("no_follow")
                val noFollow: Boolean,
                @SerializedName("num_comments")
                val numComments: Int,
                @SerializedName("num_crossposts")
                val numCrossposts: Int,
                @SerializedName("num_reports")
                val numReports: Any?,
                @SerializedName("over_18")
                val over18: Boolean,
                @SerializedName("parent_whitelist_status")
                val parentWhitelistStatus: String,
                val permalink: String,
                val pinned: Boolean,
                @SerializedName("post_hint")
                val postHint: String?,
                val preview: Preview?,
                val pwls: Int,
                val quarantine: Boolean,
                @SerializedName("removal_reason")
                val removalReason: Any?,
                @SerializedName("removed_by")
                val removedBy: Any?,
                @SerializedName("removed_by_category")
                val removedByCategory: Any?,
                @SerializedName("report_reasons")
                val reportReasons: Any?,
                val saved: Boolean,
                val score: Int,
                @SerializedName("secure_media")
                val secureMedia: SecureMedia?,
                @SerializedName("secure_media_embed")
                val secureMediaEmbed: SecureMediaEmbed?,
                val selftext: String,
                @SerializedName("selftext_html")
                val selftextHtml: Any?,
                @SerializedName("send_replies")
                val sendReplies: Boolean,
                val spoiler: Boolean,
                val stickied: Boolean,
                val subreddit: String,
                @SerializedName("subreddit_id")
                val subredditId: String,
                @SerializedName("subreddit_name_prefixed")
                val subredditNamePrefixed: String,
                @SerializedName("subreddit_subscribers")
                val subredditSubscribers: Int,
                @SerializedName("subreddit_type")
                val subredditType: String,
                @SerializedName("suggested_sort")
                val suggestedSort: Any?,
                val thumbnail: String,
                @SerializedName("thumbnail_height")
                val thumbnailHeight: Int?,
                @SerializedName("thumbnail_width")
                val thumbnailWidth: Int?,
                val title: String,
                @SerializedName("top_awarded_type")
                val topAwardedType: Any?,
                @SerializedName("total_awards_received")
                val totalAwardsReceived: Int,
                @SerializedName("tournament_data")
                val tournamentData: TournamentData?,
                @SerializedName("treatment_tags")
                val treatmentTags: List<Any>,
                val ups: Int,
                @SerializedName("upvote_ratio")
                val upvoteRatio: Double,
                val url: String,
                @SerializedName("url_overridden_by_dest")
                val urlOverriddenByDest: String,
                @SerializedName("user_reports")
                val userReports: List<Any>,
                @SerializedName("view_count")
                val viewCount: Any?,
                val visited: Boolean,
                @SerializedName("whitelist_status")
                val whitelistStatus: String,
                val wls: Int
            ) {
                data class AllAwarding(
                    @SerializedName("award_sub_type")
                    val awardSubType: String,
                    @SerializedName("award_type")
                    val awardType: String,
                    @SerializedName("awardings_required_to_grant_benefits")
                    val awardingsRequiredToGrantBenefits: Any?,
                    @SerializedName("coin_price")
                    val coinPrice: Int,
                    @SerializedName("coin_reward")
                    val coinReward: Int,
                    val count: Int,
                    @SerializedName("days_of_drip_extension")
                    val daysOfDripExtension: Any?,
                    @SerializedName("days_of_premium")
                    val daysOfPremium: Int?,
                    val description: String,
                    @SerializedName("end_date")
                    val endDate: Any?,
                    @SerializedName("giver_coin_reward")
                    val giverCoinReward: Any?,
                    @SerializedName("icon_format")
                    val iconFormat: String?,
                    @SerializedName("icon_height")
                    val iconHeight: Int,
                    @SerializedName("icon_url")
                    val iconUrl: String,
                    @SerializedName("icon_width")
                    val iconWidth: Int,
                    val id: String,
                    @SerializedName("is_enabled")
                    val isEnabled: Boolean,
                    @SerializedName("is_new")
                    val isNew: Boolean,
                    val name: String,
                    @SerializedName("penny_donate")
                    val pennyDonate: Any?,
                    @SerializedName("penny_price")
                    val pennyPrice: Int?,
                    @SerializedName("resized_icons")
                    val resizedIcons: List<ResizedIcon>,
                    @SerializedName("resized_static_icons")
                    val resizedStaticIcons: List<ResizedStaticIcon>,
                    @SerializedName("start_date")
                    val startDate: Any?,
                    @SerializedName("static_icon_height")
                    val staticIconHeight: Int,
                    @SerializedName("static_icon_url")
                    val staticIconUrl: String,
                    @SerializedName("static_icon_width")
                    val staticIconWidth: Int,
                    @SerializedName("sticky_duration_seconds")
                    val stickyDurationSeconds: Any?,
                    @SerializedName("subreddit_coin_reward")
                    val subredditCoinReward: Int,
                    @SerializedName("subreddit_id")
                    val subredditId: Any?,
                    @SerializedName("tiers_by_required_awardings")
                    val tiersByRequiredAwardings: Any?
                ) {
                    data class ResizedIcon(
                        val height: Int,
                        val url: String,
                        val width: Int
                    )

                    data class ResizedStaticIcon(
                        val height: Int,
                        val url: String,
                        val width: Int
                    )
                }

                data class AuthorFlairRichtext(
                    val a: String?,
                    val e: String,
                    val t: String?,
                    val u: String?
                )

                data class Gildings(
                    @SerializedName("gid_1")
                    val gid1: Int?,
                    @SerializedName("gid_2")
                    val gid2: Int?
                )

                data class LinkFlairRichtext(
                    val e: String,
                    val t: String
                )

                data class Media(
                    @SerializedName("reddit_video")
                    val redditVideo: RedditVideo
                ) {
                    data class RedditVideo(
                        @SerializedName("bitrate_kbps")
                        val bitrateKbps: Int,
                        @SerializedName("dash_url")
                        val dashUrl: String,
                        val duration: Int,
                        @SerializedName("fallback_url")
                        val fallbackUrl: String,
                        val height: Int,
                        @SerializedName("hls_url")
                        val hlsUrl: String,
                        @SerializedName("is_gif")
                        val isGif: Boolean,
                        @SerializedName("scrubber_media_url")
                        val scrubberMediaUrl: String,
                        @SerializedName("transcoding_status")
                        val transcodingStatus: String,
                        val width: Int
                    )
                }

                class MediaEmbed

                data class Preview(
                    val enabled: Boolean,
                    val images: List<Image>
                ) {
                    data class Image(
                        val id: String,
                        val resolutions: List<Resolution>,
                        val source: Source,
                        val variants: Variants?
                    ) {
                        data class Resolution(
                            val height: Int,
                            val url: String,
                            val width: Int
                        )

                        data class Source(
                            val height: Int,
                            val url: String,
                            val width: Int
                        )

                        data class Variants(
                            val gif: Gif?,
                            val mp4: Mp4?
                        ) {
                            data class Gif(
                                val resolutions: List<Resolution>,
                                val source: Source
                            ) {
                                data class Resolution(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )

                                data class Source(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )
                            }

                            data class Mp4(
                                val resolutions: List<Resolution>,
                                val source: Source
                            ) {
                                data class Resolution(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )

                                data class Source(
                                    val height: Int,
                                    val url: String,
                                    val width: Int
                                )
                            }
                        }
                    }
                }

                data class SecureMedia(
                    @SerializedName("reddit_video")
                    val redditVideo: RedditVideo
                ) {
                    data class RedditVideo(
                        @SerializedName("bitrate_kbps")
                        val bitrateKbps: Int,
                        @SerializedName("dash_url")
                        val dashUrl: String,
                        val duration: Int,
                        @SerializedName("fallback_url")
                        val fallbackUrl: String,
                        val height: Int,
                        @SerializedName("hls_url")
                        val hlsUrl: String,
                        @SerializedName("is_gif")
                        val isGif: Boolean,
                        @SerializedName("scrubber_media_url")
                        val scrubberMediaUrl: String,
                        @SerializedName("transcoding_status")
                        val transcodingStatus: String,
                        val width: Int
                    )
                }

                class SecureMediaEmbed

                data class TournamentData(
                    val currency: String,
                    val name: String,
                    val predictions: List<Prediction>,
                    val status: String,
                    @SerializedName("subreddit_id")
                    val subredditId: String,
                    @SerializedName("theme_id")
                    val themeId: String,
                    @SerializedName("total_participants")
                    val totalParticipants: Int,
                    @SerializedName("tournament_id")
                    val tournamentId: String
                ) {
                    data class Prediction(
                        val body: String,
                        @SerializedName("created_at")
                        val createdAt: Long,
                        val id: String,
                        @SerializedName("is_nsfw")
                        val isNsfw: Boolean,
                        @SerializedName("is_rtjson")
                        val isRtjson: Boolean,
                        @SerializedName("is_spoiler")
                        val isSpoiler: Boolean,
                        val options: List<Option>,
                        @SerializedName("resolved_option_id")
                        val resolvedOptionId: String?,
                        val status: String,
                        val title: String,
                        @SerializedName("total_stake_amount")
                        val totalStakeAmount: Int,
                        @SerializedName("total_vote_count")
                        val totalVoteCount: Int,
                        @SerializedName("user_selection")
                        val userSelection: Any?,
                        @SerializedName("user_won_amount")
                        val userWonAmount: Any?,
                        @SerializedName("vote_updates_remained")
                        val voteUpdatesRemained: Any?,
                        @SerializedName("voting_end_timestamp")
                        val votingEndTimestamp: Long
                    ) {
                        data class Option(
                            val id: String,
                            @SerializedName("image_url")
                            val imageUrl: Any?,
                            val text: String,
                            @SerializedName("total_amount")
                            val totalAmount: Int,
                            @SerializedName("user_amount")
                            val userAmount: Any?,
                            @SerializedName("vote_count")
                            val voteCount: Int
                        )
                    }
                }
            }
        }
    }
}