package com.squareup.wire.protos

import com.google.protobuf.DescriptorProtos
import com.google.protobuf.Descriptors
import com.google.protobuf.Descriptors.Descriptor
import com.google.protobuf.Descriptors.FileDescriptor.buildFrom

/**
 * Utility class to retrieve type descriptors from encoded Wire file descriptors.
 */
object ProtoTypeDescriptor {
  /**
   * `get` returns the message descriptor in position `pos` in the encoded file descriptor in the
   * class path `path`. It returns the descriptor or runtime exception if the descriptor
   * path is not in the classpath and there is no message in position `pos`
   */
  fun getMessageDescriptor(
    path: String,
    pos: Int,
    dependencies: Array<Descriptors.FileDescriptor>
  ): Descriptor {
    val content = this.javaClass.getResourceAsStream(path)?.use {
      it.readBytes()
    } ?: throw RuntimeException("could not find descriptor for class $path")
    // TODO(kalfonso): review using extension registry
    val proto = DescriptorProtos.FileDescriptorProto.parseFrom(content)
    val descriptor = buildFrom(proto, dependencies, true)
    return descriptor.messageTypes[pos]
  }
}