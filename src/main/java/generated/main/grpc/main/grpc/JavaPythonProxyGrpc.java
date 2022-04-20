package main.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.1)",
    comments = "Source: JavaPythonProxy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class JavaPythonProxyGrpc {

  private JavaPythonProxyGrpc() {}

  public static final String SERVICE_NAME = "JavaPythonProxy";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<main.grpc.JavaPythonProxyOuterClass.Command,
      main.grpc.JavaPythonProxyOuterClass.Response> getExecuteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "execute",
      requestType = main.grpc.JavaPythonProxyOuterClass.Command.class,
      responseType = main.grpc.JavaPythonProxyOuterClass.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<main.grpc.JavaPythonProxyOuterClass.Command,
      main.grpc.JavaPythonProxyOuterClass.Response> getExecuteMethod() {
    io.grpc.MethodDescriptor<main.grpc.JavaPythonProxyOuterClass.Command, main.grpc.JavaPythonProxyOuterClass.Response> getExecuteMethod;
    if ((getExecuteMethod = JavaPythonProxyGrpc.getExecuteMethod) == null) {
      synchronized (JavaPythonProxyGrpc.class) {
        if ((getExecuteMethod = JavaPythonProxyGrpc.getExecuteMethod) == null) {
          JavaPythonProxyGrpc.getExecuteMethod = getExecuteMethod =
              io.grpc.MethodDescriptor.<main.grpc.JavaPythonProxyOuterClass.Command, main.grpc.JavaPythonProxyOuterClass.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "execute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.grpc.JavaPythonProxyOuterClass.Command.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  main.grpc.JavaPythonProxyOuterClass.Response.getDefaultInstance()))
              .setSchemaDescriptor(new JavaPythonProxyMethodDescriptorSupplier("execute"))
              .build();
        }
      }
    }
    return getExecuteMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JavaPythonProxyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JavaPythonProxyStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JavaPythonProxyStub>() {
        @java.lang.Override
        public JavaPythonProxyStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JavaPythonProxyStub(channel, callOptions);
        }
      };
    return JavaPythonProxyStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JavaPythonProxyBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JavaPythonProxyBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JavaPythonProxyBlockingStub>() {
        @java.lang.Override
        public JavaPythonProxyBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JavaPythonProxyBlockingStub(channel, callOptions);
        }
      };
    return JavaPythonProxyBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JavaPythonProxyFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<JavaPythonProxyFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<JavaPythonProxyFutureStub>() {
        @java.lang.Override
        public JavaPythonProxyFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new JavaPythonProxyFutureStub(channel, callOptions);
        }
      };
    return JavaPythonProxyFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class JavaPythonProxyImplBase implements io.grpc.BindableService {

    /**
     */
    public void execute(main.grpc.JavaPythonProxyOuterClass.Command request,
        io.grpc.stub.StreamObserver<main.grpc.JavaPythonProxyOuterClass.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getExecuteMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                main.grpc.JavaPythonProxyOuterClass.Command,
                main.grpc.JavaPythonProxyOuterClass.Response>(
                  this, METHODID_EXECUTE)))
          .build();
    }
  }

  /**
   */
  public static final class JavaPythonProxyStub extends io.grpc.stub.AbstractAsyncStub<JavaPythonProxyStub> {
    private JavaPythonProxyStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JavaPythonProxyStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JavaPythonProxyStub(channel, callOptions);
    }

    /**
     */
    public void execute(main.grpc.JavaPythonProxyOuterClass.Command request,
        io.grpc.stub.StreamObserver<main.grpc.JavaPythonProxyOuterClass.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getExecuteMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class JavaPythonProxyBlockingStub extends io.grpc.stub.AbstractBlockingStub<JavaPythonProxyBlockingStub> {
    private JavaPythonProxyBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JavaPythonProxyBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JavaPythonProxyBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<main.grpc.JavaPythonProxyOuterClass.Response> execute(
        main.grpc.JavaPythonProxyOuterClass.Command request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getExecuteMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class JavaPythonProxyFutureStub extends io.grpc.stub.AbstractFutureStub<JavaPythonProxyFutureStub> {
    private JavaPythonProxyFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JavaPythonProxyFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new JavaPythonProxyFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_EXECUTE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JavaPythonProxyImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JavaPythonProxyImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_EXECUTE:
          serviceImpl.execute((main.grpc.JavaPythonProxyOuterClass.Command) request,
              (io.grpc.stub.StreamObserver<main.grpc.JavaPythonProxyOuterClass.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class JavaPythonProxyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JavaPythonProxyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return main.grpc.JavaPythonProxyOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JavaPythonProxy");
    }
  }

  private static final class JavaPythonProxyFileDescriptorSupplier
      extends JavaPythonProxyBaseDescriptorSupplier {
    JavaPythonProxyFileDescriptorSupplier() {}
  }

  private static final class JavaPythonProxyMethodDescriptorSupplier
      extends JavaPythonProxyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JavaPythonProxyMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (JavaPythonProxyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JavaPythonProxyFileDescriptorSupplier())
              .addMethod(getExecuteMethod())
              .build();
        }
      }
    }
    return result;
  }
}
