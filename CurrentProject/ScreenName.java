public enum ScreenName {
    MENU(0),
    GAME(1),
    GAME_OVER(2);
    
    private int index;
    
    private ScreenName(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
}
