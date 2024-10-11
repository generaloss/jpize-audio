package jpize.audio.util;

import jpize.audio.al.buffer.AlBuffer;
import jpize.audio.al.source.AlSource;
import jpize.util.Disposable;

public class AlSourcePool implements Disposable {

    private final AlSource[] sources;

    public AlSourcePool(int count) {
        this.sources = new AlSource[count];
        for(int i = 0; i < sources.length; i++)
            sources[i] = new AlSource();
    }

    public AlSource[] getSources() {
        return sources;
    }

    private int findFreeSourceIndex() {
        int low = 0;
        int high = sources.length - 1;
        while(low <= high){
            final int mid = low + high >>> 1;
            if(sources[mid].isPlaying()){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    public AlSource findFreeSource() {
        final int index = this.findFreeSourceIndex();
        if(index < 0 || index == sources.length)
            return null;
        return sources[index];
    }

    public AlSource play(AlBuffer buffer, double gain, double pitch) {
        final AlSource source = findFreeSource();
        if(source == null)
            return null;

        source.setBuffer(buffer);
        source.setGain(gain);
        source.setPitch(pitch);
        source.play();
        return source;
    }

    public AlSource play(AlBuffer buffer, double gain) {
        return play(buffer, gain, 1D);
    }

    public AlSource play(AlBuffer buffer) {
        return play(buffer, 1D);
    }

    @Override
    public void dispose() {
        for(AlSource source: sources){
            source.stop();
            source.dispose();
        }
    }

}
