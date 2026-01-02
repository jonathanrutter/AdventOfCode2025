package com.wuppski.advent05;

public record Range(long minValue, long maxValue) {

    public Range(String rawRange) {
        this(
            Long.parseLong(rawRange.substring(0, rawRange.indexOf('-'))),
            Long.parseLong(rawRange.substring(rawRange.indexOf('-') +1))
            );
    }

    public boolean containsValue(long value) {
        return (minValue <= value) && (maxValue >= value);
    }

    public Range merge(Range newRange) //throws RangeNotAdjacentException
    {
        // If originalRange completely includes newRange return originalRange
        if (this.containsValue(newRange.minValue) && this.containsValue(newRange.maxValue)) {
            return this;
        }

        // If newRange completely includes originalRange return newRange
        if (newRange.containsValue(this.minValue) && newRange.containsValue(this.maxValue)) {
            return newRange;
        }

        // newRange intersects originalRange and goes higher
        if (this.containsValue(newRange.minValue) || this.maxValue +1 == newRange.minValue) {
            return new Range(this.minValue, newRange.maxValue);
        }

        // newRange intersects originalRange and starts lower
        if (this.containsValue(newRange.maxValue) || this.minValue -1 == newRange.maxValue) {
            return new Range(newRange.minValue, this.maxValue);
        }
        return null;
//        throw new RangeNotAdjacentException(this, newRange);
    }

    @Override
    public String toString() {
        return String.format("range (min: %d, max: %d)", minValue, maxValue);
    }
}
