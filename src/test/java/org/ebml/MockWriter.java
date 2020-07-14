package org.ebml;

import java.nio.ByteBuffer;

import org.ebml.io.DataWriter;

public class MockWriter implements DataWriter
{
  @SuppressWarnings("unused")
  private final ByteBuffer buff = ByteBuffer.allocate(4096);

  @Override
  public long length()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long getFilePointer()
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean isSeekable()
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public long seek(final long pos)
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int write(final byte b)
  {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int write(final ByteBuffer buff)
  {
    this.buff.put(buff);
    return buff.remaining();
  }

  public ByteBuffer getBuff()
  {
    return buff;
  }
}
