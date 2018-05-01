package dAd;

public class vect {
	private double X, Y, Z;
	public vect(double x, double y, double z) {
		X = x;
		Y = y;
		Z = z;
	}public vect(double x, double y) { 
		X = x;
		Y = y;
		Z = 0.0;
	}
	public vect times(double s) {
		return new vect(X * s, Y * s, Z * s);
	}
	public vect plus(vect v){
		return new vect(X + v.X, Y + v.Y, Z + v.Z);
	}
	public double distance(vect v) {
		return Math.sqrt(Math.pow((v.X - X), 2) + Math.pow((v.Y - Y), 2) + Math.pow((v.Z - Z), 2) );
	}public double distanceSqr(vect v) {
		return (Math.pow((v.X - X), 2) + Math.pow((v.Y - Y), 2) + Math.pow((v.Z - Z), 2) );
	}
	public double getX() {
		return X;
	}public double getY() {
		return Y;
	}public double getZ() {
		return Z;
	}
	public void setX(double x) {
		X = x;
	}public void setY(double y) {
		Y = y;
	}public void setZ(double z) {
		Z = z;
	}
}
