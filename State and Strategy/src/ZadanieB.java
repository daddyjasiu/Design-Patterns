class State {
    void Next(Context state){}
    void Prev(Context state){}
    void TxValidated(Context state){}
    void TxInvalidated(Context state){}
    void BranchReplaced(Context state){}
    void IncludedInNewBlock(Context state){}
    void Orphaned(Context state){}
    void NewBlockBuiltOnTop(Context state){}
    void EnoughBlocksBuiltOnTop(Context state){}
    void PrintStatus(Context state){}
}

class Context {
    private State state = new BlockCreated();

    public void SetState(State state){
        this.state = state;
    }
    public State GetState(State state){
        return state;
    }
    public void NextState(){
        state.Next(this);
    }
    public void PreviousState(){
        state.Prev(this);
    }
    void TxValidated(Context state){
        this.state.TxValidated(state);
    }
    void TxInvalidated(Context state){
        this.state.TxInvalidated(state);
    }
    void BranchReplaced(Context state){
        this.state.BranchReplaced(state);
    }
    void IncludedInNewBlock(Context state){
        this.state.IncludedInNewBlock(state);
    }
    void Orphaned(Context state){
        this.state.Orphaned(state);
    }
    void NewBlockBuiltOnTop(Context state){
        this.state.NewBlockBuiltOnTop(state);
    }
    void EnoughBlocksBuiltOnTop(Context state){
        this.state.EnoughBlocksBuiltOnTop(state);
    }
    public void PrintStatus(){
        this.state.PrintStatus(this);
    }
}

class BlockCreated extends State {
    @Override
    public void TxValidated(Context state){
        state.SetState(new BlockValid());
    }
    @Override
    public void TxInvalidated(Context state){
        state.SetState(new BlockInvalid());
    }
    @Override
    public void PrintStatus(Context state){
        System.out.println("Block: Created");
    }
}

class BlockValid extends State {
    @Override
    public void IncludedInNewBlock(Context state){
        state.SetState(new BlockMined());
    }
    @Override
    public void BranchReplaced(Context state){
        state.SetState(new BlockInvalid());
    }
    @Override
    public void PrintStatus(Context state){
        System.out.println("Block: Valid");
    }
}

class BlockMined extends State {
    @Override
    public void NewBlockBuiltOnTop(Context state){
        state.SetState(new BlockMined());
    }
    @Override
    public void EnoughBlocksBuiltOnTop(Context state){
        state.SetState(new BlockDurablyCommitted());
    }
    @Override
    public void Orphaned(Context state){
        state.SetState(new BlockCreated());
    }
    @Override
    public void PrintStatus(Context state){
        System.out.println("Block: Mined");
    }
}

class BlockDurablyCommitted extends State {
    @Override
    public void Next(Context state){
        System.out.println("This is a final block.");
    }
    @Override
    public void PrintStatus(Context state){
        System.out.println("Block: Durably Committed");
    }
}

class BlockInvalid extends State {
    @Override
    public void Next(Context state){
        System.out.println("This is a final block.");
    }
    @Override
    public void PrintStatus(Context state){
        System.out.println("Block: Invalid");
    }
}

public class ZadanieB{

}
