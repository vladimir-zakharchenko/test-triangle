package com.tinkoff.triangle;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TriangleTest {

    @Test
    public void isRightAngled() {

        // Arrange
        ITriangle triangleABC = ITriangleProvider.getTriangle();

        Vector vectorAB = new Vector(triangleABC.getX2() - triangleABC.getX1(), triangleABC.getY2() - triangleABC.getY1());
        Vector vectorBC = new Vector(triangleABC.getX3() - triangleABC.getX2(), triangleABC.getY3() - triangleABC.getY2());
        Vector vectorCA = new Vector(triangleABC.getX1() - triangleABC.getX3(), triangleABC.getY1() - triangleABC.getY3());

        // Act, Assert
        assertThat(areOrthogonal(vectorAB, vectorBC) || areOrthogonal(vectorBC, vectorCA) || areOrthogonal(vectorCA, vectorAB))
                .as("This is not a right-angled triangle")
                .isTrue();
    }

    private int dotProduct(Vector vector1, Vector vector2) {
        return vector1.x * vector2.x + vector1.y * vector2.y;
    }

    private boolean areOrthogonal(Vector vector1, Vector vector2) {
        return dotProduct(vector1, vector2) == 0;
    }

    private class Vector {
        private int x;
        private int y;

        Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
