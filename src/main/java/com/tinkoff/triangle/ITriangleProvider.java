package com.tinkoff.triangle;

public final class ITriangleProvider {

    public static ITriangle getTriangle() {

        return new ITriangle() {
            public int getX1() {
                return 4;
            }

            public int getY1() {
                return 1;
            }

            public int getX2() {
                return 4;
            }

            public int getY2() {
                return 5;
            }

            public int getX3() {
                return 1;
            }

            public int getY3() {
                return 5;
            }
        };
    }
}
