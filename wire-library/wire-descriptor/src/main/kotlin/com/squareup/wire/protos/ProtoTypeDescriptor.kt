package com.squareup.wire.protos

import com.google.protobuf.Descriptors.Descriptor
import com.squareup.wire.Message

/**
 * Utility class to retrieve type descriptor from encoded Wire file descriptors.
 */
object ProtoTypeDescriptor {
  /**
   * Returns the proto descriptor for this message.
   */
  inline fun <reified T: Message<T, *>> getMessageDescriptor(record: T): Descriptor {
    throw NotImplementedError()
  }
}