/*
 * Copyright 2019, Backblaze Inc. All Rights Reserved.
 * License https://www.backblaze.com/using_b2_code.html
 */
package com.backblaze.b2.client;

import com.backblaze.b2.client.exceptions.B2Exception;
import com.backblaze.b2.client.structures.B2Part;
import org.junit.Test;

import static com.backblaze.b2.client.B2TestHelpers.fileId;
import static com.backblaze.b2.client.B2TestHelpers.makeSha1;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class B2AlreadyStoredPartStorerTest {

    @Test
    public void testStorePart() throws B2Exception {
        final B2Part part = new B2Part(fileId(1), 2, 10000000, makeSha1(1), 1111);
        final B2AlreadyStoredPartStorer partStorer = new B2AlreadyStoredPartStorer(part);
        assertEquals(part, partStorer.storePart(mock(B2LargeFileStorer.class)));
    }
}