package net.gtexcalibur.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * Created by George Turner on 10/20/2017.
 */
public abstract class MultipleElementSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
    private List<T> buffer;

    public MultipleElementSpliterator(long est, int additionalCharacteristics) {
        super(est, additionalCharacteristics);
    }

    @Override
    public final boolean tryAdvance(Consumer<? super T> action) {
        // A workaround for the JDK, specifically Spliterators.iterator(Spliterator<?>)
        if(action instanceof Iterator) {
            if(buffer != null && !buffer.isEmpty()) {
                action.accept(buffer.remove(0));
                if(!buffer.isEmpty()) {
                    return true;
                }
            }
            buffer = new ArrayList<>();
            boolean more = tryAdvanceMultiple(buffer::add);
            if(!buffer.isEmpty()) {
                action.accept(buffer.remove(0));
            }
            return more || !buffer.isEmpty();
        } else {
            return tryAdvanceMultiple(action);
        }
    }

    protected abstract boolean tryAdvanceMultiple(Consumer<? super T> action);
}
