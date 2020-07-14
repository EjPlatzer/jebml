package org.ebml.matroska;

import java.util.ArrayList;

import org.ebml.MasterElement;
import org.ebml.io.DataWriter;

public class MatroskaFileTracks
{
  private static final int BLOCK_SIZE = 4096;

  private final ArrayList<MatroskaFileTrack> tracks = new ArrayList<>();

  private long myPosition;

  public void addTrack(final MatroskaFileTrack track)
  {
    tracks.add(track);
  }

  public long writeTracks(final DataWriter ioDW)
  {
    myPosition = ioDW.getFilePointer();
    final MasterElement tracksElem = MatroskaDocTypes.Tracks.getInstance();

    for (final MatroskaFileTrack track : tracks)
    {
      tracksElem.addChildElement(track.toElement());
    }
    tracksElem.writeElement(ioDW);
    assert BLOCK_SIZE > tracksElem.getTotalSize();
    new VoidElement(BLOCK_SIZE - tracksElem.getTotalSize()).writeElement(ioDW);
    return BLOCK_SIZE;
  }

  public void update(final DataWriter ioDW)
  {
    final long start = ioDW.getFilePointer();
    ioDW.seek(myPosition);
    writeTracks(ioDW);
    ioDW.seek(start);
  }
}
