// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.foreign.ForeignMessage in foreign.proto
package com.squareup.wire.protos.foreign;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.ReverseProtoWriter;
import com.squareup.wire.Syntax;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import okio.ByteString;

public final class ForeignMessage extends Message<ForeignMessage, ForeignMessage.Builder> {
  public static final ProtoAdapter<ForeignMessage> ADAPTER = new ProtoAdapter_ForeignMessage();

  private static final long serialVersionUID = 0L;

  public static final Integer DEFAULT_I = 0;

  public static final Integer DEFAULT_J = 0;

  @WireField(
      tag = 1,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer i;

  /**
   * Extension source: simple_message.proto
   */
  @WireField(
      tag = 100,
      adapter = "com.squareup.wire.ProtoAdapter#INT32"
  )
  public final Integer j;

  public ForeignMessage(Integer i, Integer j) {
    this(i, j, ByteString.EMPTY);
  }

  public ForeignMessage(Integer i, Integer j, ByteString unknownFields) {
    super(ADAPTER, unknownFields);
    this.i = i;
    this.j = j;
  }

  @Override
  public Builder newBuilder() {
    Builder builder = new Builder();
    builder.i = i;
    builder.j = j;
    builder.addUnknownFields(unknownFields());
    return builder;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) return true;
    if (!(other instanceof ForeignMessage)) return false;
    ForeignMessage o = (ForeignMessage) other;
    return unknownFields().equals(o.unknownFields())
        && Internal.equals(i, o.i)
        && Internal.equals(j, o.j);
  }

  @Override
  public int hashCode() {
    int result = super.hashCode;
    if (result == 0) {
      result = unknownFields().hashCode();
      result = result * 37 + (i != null ? i.hashCode() : 0);
      result = result * 37 + (j != null ? j.hashCode() : 0);
      super.hashCode = result;
    }
    return result;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    if (i != null) builder.append(", i=").append(i);
    if (j != null) builder.append(", j=").append(j);
    return builder.replace(0, 2, "ForeignMessage{").append('}').toString();
  }

  public static final class Builder extends Message.Builder<ForeignMessage, Builder> {
    public Integer i;

    public Integer j;

    public Builder() {
    }

    public Builder i(Integer i) {
      this.i = i;
      return this;
    }

    public Builder j(Integer j) {
      this.j = j;
      return this;
    }

    @Override
    public ForeignMessage build() {
      return new ForeignMessage(i, j, super.buildUnknownFields());
    }
  }

  private static final class ProtoAdapter_ForeignMessage extends ProtoAdapter<ForeignMessage> {
    public ProtoAdapter_ForeignMessage() {
      super(FieldEncoding.LENGTH_DELIMITED, ForeignMessage.class, "type.googleapis.com/squareup.protos.foreign.ForeignMessage", Syntax.PROTO_2, null);
    }

    @Override
    public int encodedSize(ForeignMessage value) {
      int result = 0;
      result += ProtoAdapter.INT32.encodedSizeWithTag(1, value.i);
      result += ProtoAdapter.INT32.encodedSizeWithTag(100, value.j);
      result += value.unknownFields().size();
      return result;
    }

    @Override
    public void encode(ProtoWriter writer, ForeignMessage value) throws IOException {
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i);
      ProtoAdapter.INT32.encodeWithTag(writer, 100, value.j);
      writer.writeBytes(value.unknownFields());
    }

    @Override
    public void encode(ReverseProtoWriter writer, ForeignMessage value) throws IOException {
      writer.writeBytes(value.unknownFields());
      ProtoAdapter.INT32.encodeWithTag(writer, 100, value.j);
      ProtoAdapter.INT32.encodeWithTag(writer, 1, value.i);
    }

    @Override
    public ForeignMessage decode(ProtoReader reader) throws IOException {
      Builder builder = new Builder();
      long token = reader.beginMessage();
      for (int tag; (tag = reader.nextTag()) != -1;) {
        switch (tag) {
          case 1: builder.i(ProtoAdapter.INT32.decode(reader)); break;
          case 100: builder.j(ProtoAdapter.INT32.decode(reader)); break;
          default: {
            reader.readUnknownField(tag);
          }
        }
      }
      builder.addUnknownFields(reader.endMessageAndGetUnknownFields(token));
      return builder.build();
    }

    @Override
    public ForeignMessage redact(ForeignMessage value) {
      Builder builder = value.newBuilder();
      builder.clearUnknownFields();
      return builder.build();
    }
  }
}
