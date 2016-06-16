// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ResourceTrackerProtocol.proto

package org.apache.tajo.ipc;

public final class TajoResourceTrackerProtocol {
  private TajoResourceTrackerProtocol() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  /**
   * Protobuf service {@code hadoop.yarn.TajoResourceTrackerProtocolService}
   */
  public static abstract class TajoResourceTrackerProtocolService
      implements com.google.protobuf.Service {
    protected TajoResourceTrackerProtocolService() {}

    public interface Interface {
      /**
       * <code>rpc nodeHeartbeat(.NodeHeartbeatRequest) returns (.NodeHeartbeatResponse);</code>
       */
      public abstract void nodeHeartbeat(
          com.google.protobuf.RpcController controller,
          org.apache.tajo.ResourceProtos.NodeHeartbeatRequest request,
          com.google.protobuf.RpcCallback<org.apache.tajo.ResourceProtos.NodeHeartbeatResponse> done);

    }

    public static com.google.protobuf.Service newReflectiveService(
        final Interface impl) {
      return new TajoResourceTrackerProtocolService() {
        @java.lang.Override
        public  void nodeHeartbeat(
            com.google.protobuf.RpcController controller,
            org.apache.tajo.ResourceProtos.NodeHeartbeatRequest request,
            com.google.protobuf.RpcCallback<org.apache.tajo.ResourceProtos.NodeHeartbeatResponse> done) {
          impl.nodeHeartbeat(controller, request, done);
        }

      };
    }

    public static com.google.protobuf.BlockingService
        newReflectiveBlockingService(final BlockingInterface impl) {
      return new com.google.protobuf.BlockingService() {
        public final com.google.protobuf.Descriptors.ServiceDescriptor
            getDescriptorForType() {
          return getDescriptor();
        }

        public final com.google.protobuf.Message callBlockingMethod(
            com.google.protobuf.Descriptors.MethodDescriptor method,
            com.google.protobuf.RpcController controller,
            com.google.protobuf.Message request)
            throws com.google.protobuf.ServiceException {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.callBlockingMethod() given method descriptor for " +
              "wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return impl.nodeHeartbeat(controller, (org.apache.tajo.ResourceProtos.NodeHeartbeatRequest)request);
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getRequestPrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.getRequestPrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return org.apache.tajo.ResourceProtos.NodeHeartbeatRequest.getDefaultInstance();
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

        public final com.google.protobuf.Message
            getResponsePrototype(
            com.google.protobuf.Descriptors.MethodDescriptor method) {
          if (method.getService() != getDescriptor()) {
            throw new java.lang.IllegalArgumentException(
              "Service.getResponsePrototype() given method " +
              "descriptor for wrong service type.");
          }
          switch(method.getIndex()) {
            case 0:
              return org.apache.tajo.ResourceProtos.NodeHeartbeatResponse.getDefaultInstance();
            default:
              throw new java.lang.AssertionError("Can't get here.");
          }
        }

      };
    }

    /**
     * <code>rpc nodeHeartbeat(.NodeHeartbeatRequest) returns (.NodeHeartbeatResponse);</code>
     */
    public abstract void nodeHeartbeat(
        com.google.protobuf.RpcController controller,
        org.apache.tajo.ResourceProtos.NodeHeartbeatRequest request,
        com.google.protobuf.RpcCallback<org.apache.tajo.ResourceProtos.NodeHeartbeatResponse> done);

    public static final
        com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptor() {
      return org.apache.tajo.ipc.TajoResourceTrackerProtocol.getDescriptor().getServices().get(0);
    }
    public final com.google.protobuf.Descriptors.ServiceDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }

    public final void callMethod(
        com.google.protobuf.Descriptors.MethodDescriptor method,
        com.google.protobuf.RpcController controller,
        com.google.protobuf.Message request,
        com.google.protobuf.RpcCallback<
          com.google.protobuf.Message> done) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.callMethod() given method descriptor for wrong " +
          "service type.");
      }
      switch(method.getIndex()) {
        case 0:
          this.nodeHeartbeat(controller, (org.apache.tajo.ResourceProtos.NodeHeartbeatRequest)request,
            com.google.protobuf.RpcUtil.<org.apache.tajo.ResourceProtos.NodeHeartbeatResponse>specializeCallback(
              done));
          return;
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getRequestPrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.getRequestPrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return org.apache.tajo.ResourceProtos.NodeHeartbeatRequest.getDefaultInstance();
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public final com.google.protobuf.Message
        getResponsePrototype(
        com.google.protobuf.Descriptors.MethodDescriptor method) {
      if (method.getService() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "Service.getResponsePrototype() given method " +
          "descriptor for wrong service type.");
      }
      switch(method.getIndex()) {
        case 0:
          return org.apache.tajo.ResourceProtos.NodeHeartbeatResponse.getDefaultInstance();
        default:
          throw new java.lang.AssertionError("Can't get here.");
      }
    }

    public static Stub newStub(
        com.google.protobuf.RpcChannel channel) {
      return new Stub(channel);
    }

    public static final class Stub extends org.apache.tajo.ipc.TajoResourceTrackerProtocol.TajoResourceTrackerProtocolService implements Interface {
      private Stub(com.google.protobuf.RpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.RpcChannel channel;

      public com.google.protobuf.RpcChannel getChannel() {
        return channel;
      }

      public  void nodeHeartbeat(
          com.google.protobuf.RpcController controller,
          org.apache.tajo.ResourceProtos.NodeHeartbeatRequest request,
          com.google.protobuf.RpcCallback<org.apache.tajo.ResourceProtos.NodeHeartbeatResponse> done) {
        channel.callMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          org.apache.tajo.ResourceProtos.NodeHeartbeatResponse.getDefaultInstance(),
          com.google.protobuf.RpcUtil.generalizeCallback(
            done,
            org.apache.tajo.ResourceProtos.NodeHeartbeatResponse.class,
            org.apache.tajo.ResourceProtos.NodeHeartbeatResponse.getDefaultInstance()));
      }
    }

    public static BlockingInterface newBlockingStub(
        com.google.protobuf.BlockingRpcChannel channel) {
      return new BlockingStub(channel);
    }

    public interface BlockingInterface {
      public org.apache.tajo.ResourceProtos.NodeHeartbeatResponse nodeHeartbeat(
          com.google.protobuf.RpcController controller,
          org.apache.tajo.ResourceProtos.NodeHeartbeatRequest request)
          throws com.google.protobuf.ServiceException;
    }

    private static final class BlockingStub implements BlockingInterface {
      private BlockingStub(com.google.protobuf.BlockingRpcChannel channel) {
        this.channel = channel;
      }

      private final com.google.protobuf.BlockingRpcChannel channel;

      public org.apache.tajo.ResourceProtos.NodeHeartbeatResponse nodeHeartbeat(
          com.google.protobuf.RpcController controller,
          org.apache.tajo.ResourceProtos.NodeHeartbeatRequest request)
          throws com.google.protobuf.ServiceException {
        return (org.apache.tajo.ResourceProtos.NodeHeartbeatResponse) channel.callBlockingMethod(
          getDescriptor().getMethods().get(0),
          controller,
          request,
          org.apache.tajo.ResourceProtos.NodeHeartbeatResponse.getDefaultInstance());
      }

    }

    // @@protoc_insertion_point(class_scope:hadoop.yarn.TajoResourceTrackerProtocolService)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\035ResourceTrackerProtocol.proto\022\013hadoop." +
      "yarn\032\024ResourceProtos.proto2d\n\"TajoResour" +
      "ceTrackerProtocolService\022>\n\rnodeHeartbea" +
      "t\022\025.NodeHeartbeatRequest\032\026.NodeHeartbeat" +
      "ResponseB8\n\023org.apache.tajo.ipcB\033TajoRes" +
      "ourceTrackerProtocol\210\001\001\240\001\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.apache.tajo.ResourceProtos.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
