/*
 * Copyright 2021, Backblaze Inc. All Rights Reserved.
 * License https://www.backblaze.com/using_b2_code.html
 */
package com.backblaze.b2.client;

import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.exceptions.B2LocalException;

import java.io.IOException;
import java.util.List;

public interface B2PartSizer {
    default List<B2PartSpec> pickParts(B2ContentSource source) throws B2Exception {
        try {
            return pickParts(source.getContentLength());
        } catch (IOException e) {
            throw new B2LocalException("read_failed", "failed to get contentLength from source: " + e, e);
        }
    }

    List<B2PartSpec> pickParts(long contentLength);
}
