package com.google.api.client.util;

import java.io.IOException;
import java.io.OutputStream;

public interface StreamingContent
{
    void writeTo(OutputStream p0) throws IOException;
}
