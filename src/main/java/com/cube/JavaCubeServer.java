//package com.cube;
//
//
//import com.cube.grpc.CubeGrpc;
//import com.cube.grpc.CubeGrpc.CubeImplBase;
//import com.cube.grpc.CubeOuterClass;
//import com.cube.grpc.CubeOuterClass.Response;
//import io.grpc.*;
//import io.grpc.stub.StreamObserver;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;
//
//public class JavaCubeServer {
//    private static final Logger logger = Logger.getLogger(JavaCubeServer.class.getName());
//
//    private final Server server;
//    private final int port;
//
//    public JavaCubeServer(int port) throws IOException {
//        this.port = port;
//        this.server = ServerBuilder.forPort(port)
//                .addService(new JavaCubeService())
//                .build();
//    }
//
//    /** Start serving requests. */
//    public void start() throws IOException {
//        server.start();
//        logger.info("Server started, listening on " + port);
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
//                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
//                System.err.println("*** shutting down gRPC server since JVM is shutting down");
//                try {
//                    JavaCubeServer.this.stop();
//                } catch (InterruptedException e) {
//                    e.printStackTrace(System.err);
//                }
//                System.err.println("*** server shut down");
//            }
//        });
//    }
//
//    /** Stop serving requests and shutdown resources. */
//    public void stop() throws InterruptedException {
//        if (server != null) {
//            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
//        }
//    }
//
//    /**
//     * Await termination on the main thread since the grpc library uses daemon threads.
//     */
//    private void blockUntilShutdown() throws InterruptedException {
//        if (server != null) {
//            server.awaitTermination();
//        }
//    }
//
//    /**
//     * Main method.  This comment makes the linter happy.
//     */
//    public static void main(String[] args) throws Exception {
//        JavaCubeServer server = new JavaCubeServer(8980);
//        server.start();
//        server.blockUntilShutdown();
//    }
//
////    private static class JavaCubeTransportFilter extends ServerTransportFilter {
////        @Override
////        public void transportTerminated(Attributes transportAttrs) {
////            System.out.println(transportAttrs);
////            System.out.println("Transport terminated");
////        }
////    }
//
//    private static class JavaCubeService extends CubeImplBase {
//
//        @Override
//        public void executeSQL(CubeOuterClass.SQL request, StreamObserver<Response> responseObserver) {
//            System.out.println(request.getSql());
//            Context ctx = Context.current();
//
//            CubeTask task = new CubeTask("My task");
//
//            Response response = Response.newBuilder().setData("test").build();
//            responseObserver.onNext(response);
//            task.start();
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
//
//}
//
