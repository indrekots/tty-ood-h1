import math

class Point:
    "Two-dimensional points"

    def __init__(self, x=0.0, y=0.0):
        self._x = x
        self._y = y

    def __str__(self):
        result = "\n".join(["x: %f" % self.x(),
                            "y: %f" % self.y(),
                            "rho: %f" % self.rho(),
                            "theta: %f" % self.theta()])
        return result

# Queries

    def x(self):
        "Abscissa"
        return self._x

    def y(self):
        "Ordinate"
        return self._y

    def rho(self):
        "Distance to origin (0, 0)"
        return math.sqrt(self.x()**2 + self.y()**2)

    def theta(self):
        "Angle to horizontal axis"
        return math.atan2(self.y(), self.x())

    def distance(self, other):
        "Distance to other"
        return self.vectorTo(other).rho()

    def vectorTo(self, other):
        "Returns the Point representing the vector from self to other Point"
        return Point(other.x() - self.x(), other.y() - self.y())

# Commands

    def translate(self, dx, dy):
        "Move by dx horizontally, dy vertically"
        self._x += dx
        self._y += dy

    def scale(self, factor):
        "Scale by factor"
        self._x *= factor
        self._y *= factor

    def centre_rotate(self, angle):
        "Rotate around origin (0, 0) by angle"
        temp_x = self.rho() * math.cos(self.theta() + angle)
        temp_y = self.rho() * math.sin(self.theta() + angle)
        self._x, self._y = temp_x, temp_y

    def rotate(self, p, angle):
        "Rotate around p by angle"
        self.translate(-p.x(), -p.y())
        self.centre_rotate(angle)
        self.translate(p.x(), p.y())
