public class Vector2{
  public double x;
  public double y;
  public Vector2(){
    this(0.0, 0.0);
  }
  public Vector2(double x, double y)
  {
    this.x = x;
    this.y = y;
  }
  public Vector2(Vector2 clone)
  {
    this.x = clone.x;
    this.y = clone.y;
  }
  public void add(Vector2 two)
  {
    this.x += two.x;
    this.y += two.y;
  }
  public void sub(Vector2 two)
  {
    this.x -= two.x;
    this.y -= two.y;
  }
  public void scale(double amt)
  {
    this.x *= amt;
    this.y *= amt;
  }
}
