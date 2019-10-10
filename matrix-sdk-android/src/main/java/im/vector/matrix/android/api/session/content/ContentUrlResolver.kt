/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.matrix.android.api.session.content

/**
 * This interface defines methods for accessing content from the current session.
 */
interface ContentUrlResolver {

    enum class ThumbnailMethod(val value: String) {
        CROP("crop"),
        SCALE("scale")
    }

    /**
     * Get the actual URL for accessing the full-size image of a Matrix media content URI.
     *
     * @param contentUrl  the Matrix media content URI (in the form of "mxc://...").
     * @return the URL to access the described resource, or null if the url is invalid.
     */
    fun resolveFullSize(contentUrl: String?): String?

    /**
     * Get the actual URL for accessing the thumbnail image of a given Matrix media content URI.
     *
     * @param contentUrl the Matrix media content URI (in the form of "mxc://...").
     * @param width      the desired width
     * @param height     the desired height
     * @param method     the desired method (METHOD_CROP or METHOD_SCALE)
     * @return the URL to access the described resource, or null if the url is invalid.
     */
    fun resolveThumbnail(contentUrl: String?, width: Int, height: Int, method: ThumbnailMethod): String?
}
