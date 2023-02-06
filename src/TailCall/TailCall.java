package TailCall;

import java.util.function.Supplier;

public abstract class TailCall <R>{
    public abstract R eval();
    public abstract TailCall<R> resume();
    public abstract boolean isSuspend();
    public static <R> Result<R> result(R res){
        return new Result<>(res);
    }
    public static <R> Suspend<R> suspend(Supplier<TailCall<R>> suspendFunction){
        return new Suspend<R>(suspendFunction);
    }
    public static class Result<R> extends TailCall<R>{
        private final R result;

        public Result(R result) {
            this.result = result;
        }

        @Override
        public R eval() {
            return result;
        }

        @Override
        public TailCall<R> resume() {
            throw new IllegalStateException("This Is Not a Suspend Type");
        }

        @Override
        public boolean isSuspend() {
            return false;
        }
    }
    public static class Suspend<R> extends TailCall<R>{
        private final Supplier<TailCall<R>> resumeFunction;

        public Suspend(Supplier<TailCall<R>> resumeFunction) {
            this.resumeFunction = resumeFunction;
        }

        @Override
        public R eval() {
            TailCall<R> tailCall = resumeFunction.get();
            while (tailCall.isSuspend()){
                tailCall = tailCall.resume();
            }
            return tailCall.eval();
        }

        @Override
        public TailCall<R> resume() {
            return resumeFunction.get();
        }

        @Override
        public boolean isSuspend() {
            return true;
        }
    }
}
