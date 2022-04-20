package main;

import io.grpc.Context;
import io.grpc.stub.StreamObserver;
import main.grpc.JavaPythonProxyGrpc;
import main.grpc.JavaPythonProxyOuterClass;
import main.tasks.PythonTask;

import java.util.concurrent.TimeUnit;

public class JavaPythonProxyService extends JavaPythonProxyGrpc.JavaPythonProxyImplBase {
    @Override
    public void execute(JavaPythonProxyOuterClass.Command request, StreamObserver<JavaPythonProxyOuterClass.Response> responseObserver) {
        System.out.println(request.getCommand());
        Context ctx = Context.current();

        PythonTask task = new PythonTask();
        task.start();

        while (task.isAlive()) {
            System.out.println(ctx.isCancelled());
                if (ctx.isCancelled()) {
                    task.interrupt();
                }
                System.out.println("Waiting for task to complete");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        System.out.println(task.getTaskOutput());

        responseObserver.onNext(
                JavaPythonProxyOuterClass.Response.newBuilder().setData(task.getTaskOutput()).build()
        );
        responseObserver.onCompleted();
    }
//        @Override
//        public void executeSQL(CubeOuterClass.SQL request, StreamObserver<Response> responseObserver) {
//            System.out.println(request.getSql());
//            Context ctx = Context.current();
//
//            CubeTask task = new CubeTask("My task");
//
//            Response response = Response.newBuilder().setData("test").build();
//            responseObserver.onNext(response);
//            task.start()
//            while (task.isAlive()) {
//
//                if (ctx.isCancelled()) {
//                    task.interrupt();
//                }
//                System.out.println("Waiting for task to complete");
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//
//            responseObserver.onNext(Response.newBuilder().setData(task.getResult()).build());
//            responseObserver.onCompleted();
//        }
//    }

}
