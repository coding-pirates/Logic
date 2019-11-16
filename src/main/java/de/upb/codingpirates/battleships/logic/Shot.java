package de.upb.codingpirates.battleships.logic;


public class Shot {
    private Point2D target;
    private Field targetField;
    private Player shootingPlayer;
    private boolean success = false; //becomes true if shot hits ship

    public Shot(Point2D target, Field targetField, Player shootingPlayer) {
        this.target = target;
        this.targetField = targetField;
        this.shootingPlayer = shootingPlayer;
    }

    public Point2D getTarget() {
        return target;
    }

    public void setTarget(Point2D target) {
        this.target = target;
    }

    public Field getTargetField() {
        return targetField;
    }

    public void setTargetField(Field targetField) {
        this.targetField = targetField;
    }

    public Player getShootingPlayer() {
        return shootingPlayer;
    }

    public void setShootingPlayer(Player shootingPlayer) {
        this.shootingPlayer = shootingPlayer;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
