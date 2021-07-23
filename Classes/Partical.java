public class Partical{
  public Vector2 velocity;
  public Vector2 position;
  public Partical(){
    this(new Vector2(), new Vector2());
  }
  public Partical(Vector2 position){
    this(position, new Vector2());
  }
  public Partical(Vector2 position, Vector2 velocity){
    this.position = new Vector2(position);
    this.velocity = new Vector2(velocity);
  }
}
