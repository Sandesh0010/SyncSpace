public class LikePost {
    private User u;
    private PostModel p;
    private Database database;
    public LikePost(User user,PostModel post, Database database){
        this.u = u;
        this.p = p;
        this.database = database;
    }

    public boolean isLiked(User user, PostModel post){
        return database.likePost(user, post);
    }
    public boolean removeLike(User user, PostModel post){
        return database.removelikePost(user,post);
    }
}
