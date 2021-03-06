package com.google.api.client.http;

import java.io.IOException;
import java.io.OutputStream;
import com.google.api.client.util.StreamingContent;

public interface HttpEncoding
{
    String getName();
    
    void encode(StreamingContent p0, OutputStream p1) throws IOException;
}
