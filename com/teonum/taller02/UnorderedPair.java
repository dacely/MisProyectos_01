package com.teonum.taller02;

public class UnorderedPair
{
    private final int a;
    private final int b;

    public UnorderedPair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnorderedPair that = (UnorderedPair) o;
        return (a == that.a && b == that.b) || (b == that.a && a == that.b);
    }

    @Override
    public String toString()
    {
        return String.format("(%d, %d)", a, b);
    }
}
