package com.company.BacklogItems;

public abstract class BacklogItemState {
    abstract void GoNext();

    public void SetBackToToDo(){
        System.out.println("Error: Kan alleen terug naar TODO vanuit DOING");
    }
}
