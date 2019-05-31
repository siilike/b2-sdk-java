/*
 * Copyright 2019, Backblaze Inc. All Rights Reserved.
 * License https://www.backblaze.com/using_b2_code.html
 */
package com.backblaze.b2.client;

import com.backblaze.b2.client.contentSources.B2ContentSource;
import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Part;

import java.util.Objects;

/**
 * This implementation stores a part of a large file by uploading
 * the bytes from a B2ContentSource.
 */
public class B2UploadingPartStorer implements B2PartStorer {

    private final int partNumber;
    private final B2ContentSource contentSource;

    public B2UploadingPartStorer(int partNumber, B2ContentSource contentSource) {
        this.partNumber = partNumber;
        this.contentSource = contentSource;
    }

    @Override
    public B2Part storePart(B2LargeFileStorer largeFileCreationManager) throws B2Exception {
        return largeFileCreationManager.uploadPart(partNumber, contentSource);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B2UploadingPartStorer that = (B2UploadingPartStorer) o;
        return partNumber == that.partNumber &&
                Objects.equals(contentSource, that.contentSource);
    }
}

