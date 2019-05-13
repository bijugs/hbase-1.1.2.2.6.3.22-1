/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hbase.thrift.generated;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * For increments that are not incrementColumnValue
 * equivalents.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)", date = "2017-06-27")
public class TIncrement implements org.apache.thrift.TBase<TIncrement, TIncrement._Fields>, java.io.Serializable, Cloneable, Comparable<TIncrement> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TIncrement");

  private static final org.apache.thrift.protocol.TField TABLE_FIELD_DESC = new org.apache.thrift.protocol.TField("table", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField ROW_FIELD_DESC = new org.apache.thrift.protocol.TField("row", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField COLUMN_FIELD_DESC = new org.apache.thrift.protocol.TField("column", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField AMMOUNT_FIELD_DESC = new org.apache.thrift.protocol.TField("ammount", org.apache.thrift.protocol.TType.I64, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TIncrementStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TIncrementTupleSchemeFactory());
  }

  public ByteBuffer table; // required
  public ByteBuffer row; // required
  public ByteBuffer column; // required
  public long ammount; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TABLE((short)1, "table"),
    ROW((short)2, "row"),
    COLUMN((short)3, "column"),
    AMMOUNT((short)4, "ammount");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // TABLE
          return TABLE;
        case 2: // ROW
          return ROW;
        case 3: // COLUMN
          return COLUMN;
        case 4: // AMMOUNT
          return AMMOUNT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __AMMOUNT_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TABLE, new org.apache.thrift.meta_data.FieldMetaData("table", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Text")));
    tmpMap.put(_Fields.ROW, new org.apache.thrift.meta_data.FieldMetaData("row", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Text")));
    tmpMap.put(_Fields.COLUMN, new org.apache.thrift.meta_data.FieldMetaData("column", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "Text")));
    tmpMap.put(_Fields.AMMOUNT, new org.apache.thrift.meta_data.FieldMetaData("ammount", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TIncrement.class, metaDataMap);
  }

  public TIncrement() {
  }

  public TIncrement(
    ByteBuffer table,
    ByteBuffer row,
    ByteBuffer column,
    long ammount)
  {
    this();
    this.table = org.apache.thrift.TBaseHelper.copyBinary(table);
    this.row = org.apache.thrift.TBaseHelper.copyBinary(row);
    this.column = org.apache.thrift.TBaseHelper.copyBinary(column);
    this.ammount = ammount;
    setAmmountIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TIncrement(TIncrement other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetTable()) {
      this.table = other.table;
    }
    if (other.isSetRow()) {
      this.row = other.row;
    }
    if (other.isSetColumn()) {
      this.column = other.column;
    }
    this.ammount = other.ammount;
  }

  public TIncrement deepCopy() {
    return new TIncrement(this);
  }

  @Override
  public void clear() {
    this.table = null;
    this.row = null;
    this.column = null;
    setAmmountIsSet(false);
    this.ammount = 0;
  }

  public byte[] getTable() {
    setTable(org.apache.thrift.TBaseHelper.rightSize(table));
    return table == null ? null : table.array();
  }

  public ByteBuffer bufferForTable() {
    return org.apache.thrift.TBaseHelper.copyBinary(table);
  }

  public TIncrement setTable(byte[] table) {
    this.table = table == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(table, table.length));
    return this;
  }

  public TIncrement setTable(ByteBuffer table) {
    this.table = org.apache.thrift.TBaseHelper.copyBinary(table);
    return this;
  }

  public void unsetTable() {
    this.table = null;
  }

  /** Returns true if field table is set (has been assigned a value) and false otherwise */
  public boolean isSetTable() {
    return this.table != null;
  }

  public void setTableIsSet(boolean value) {
    if (!value) {
      this.table = null;
    }
  }

  public byte[] getRow() {
    setRow(org.apache.thrift.TBaseHelper.rightSize(row));
    return row == null ? null : row.array();
  }

  public ByteBuffer bufferForRow() {
    return org.apache.thrift.TBaseHelper.copyBinary(row);
  }

  public TIncrement setRow(byte[] row) {
    this.row = row == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(row, row.length));
    return this;
  }

  public TIncrement setRow(ByteBuffer row) {
    this.row = org.apache.thrift.TBaseHelper.copyBinary(row);
    return this;
  }

  public void unsetRow() {
    this.row = null;
  }

  /** Returns true if field row is set (has been assigned a value) and false otherwise */
  public boolean isSetRow() {
    return this.row != null;
  }

  public void setRowIsSet(boolean value) {
    if (!value) {
      this.row = null;
    }
  }

  public byte[] getColumn() {
    setColumn(org.apache.thrift.TBaseHelper.rightSize(column));
    return column == null ? null : column.array();
  }

  public ByteBuffer bufferForColumn() {
    return org.apache.thrift.TBaseHelper.copyBinary(column);
  }

  public TIncrement setColumn(byte[] column) {
    this.column = column == null ? (ByteBuffer)null : ByteBuffer.wrap(Arrays.copyOf(column, column.length));
    return this;
  }

  public TIncrement setColumn(ByteBuffer column) {
    this.column = org.apache.thrift.TBaseHelper.copyBinary(column);
    return this;
  }

  public void unsetColumn() {
    this.column = null;
  }

  /** Returns true if field column is set (has been assigned a value) and false otherwise */
  public boolean isSetColumn() {
    return this.column != null;
  }

  public void setColumnIsSet(boolean value) {
    if (!value) {
      this.column = null;
    }
  }

  public long getAmmount() {
    return this.ammount;
  }

  public TIncrement setAmmount(long ammount) {
    this.ammount = ammount;
    setAmmountIsSet(true);
    return this;
  }

  public void unsetAmmount() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __AMMOUNT_ISSET_ID);
  }

  /** Returns true if field ammount is set (has been assigned a value) and false otherwise */
  public boolean isSetAmmount() {
    return EncodingUtils.testBit(__isset_bitfield, __AMMOUNT_ISSET_ID);
  }

  public void setAmmountIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __AMMOUNT_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case TABLE:
      if (value == null) {
        unsetTable();
      } else {
        setTable((ByteBuffer)value);
      }
      break;

    case ROW:
      if (value == null) {
        unsetRow();
      } else {
        setRow((ByteBuffer)value);
      }
      break;

    case COLUMN:
      if (value == null) {
        unsetColumn();
      } else {
        setColumn((ByteBuffer)value);
      }
      break;

    case AMMOUNT:
      if (value == null) {
        unsetAmmount();
      } else {
        setAmmount((Long)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case TABLE:
      return getTable();

    case ROW:
      return getRow();

    case COLUMN:
      return getColumn();

    case AMMOUNT:
      return getAmmount();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case TABLE:
      return isSetTable();
    case ROW:
      return isSetRow();
    case COLUMN:
      return isSetColumn();
    case AMMOUNT:
      return isSetAmmount();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TIncrement)
      return this.equals((TIncrement)that);
    return false;
  }

  public boolean equals(TIncrement that) {
    if (that == null)
      return false;

    boolean this_present_table = true && this.isSetTable();
    boolean that_present_table = true && that.isSetTable();
    if (this_present_table || that_present_table) {
      if (!(this_present_table && that_present_table))
        return false;
      if (!this.table.equals(that.table))
        return false;
    }

    boolean this_present_row = true && this.isSetRow();
    boolean that_present_row = true && that.isSetRow();
    if (this_present_row || that_present_row) {
      if (!(this_present_row && that_present_row))
        return false;
      if (!this.row.equals(that.row))
        return false;
    }

    boolean this_present_column = true && this.isSetColumn();
    boolean that_present_column = true && that.isSetColumn();
    if (this_present_column || that_present_column) {
      if (!(this_present_column && that_present_column))
        return false;
      if (!this.column.equals(that.column))
        return false;
    }

    boolean this_present_ammount = true;
    boolean that_present_ammount = true;
    if (this_present_ammount || that_present_ammount) {
      if (!(this_present_ammount && that_present_ammount))
        return false;
      if (this.ammount != that.ammount)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_table = true && (isSetTable());
    list.add(present_table);
    if (present_table)
      list.add(table);

    boolean present_row = true && (isSetRow());
    list.add(present_row);
    if (present_row)
      list.add(row);

    boolean present_column = true && (isSetColumn());
    list.add(present_column);
    if (present_column)
      list.add(column);

    boolean present_ammount = true;
    list.add(present_ammount);
    if (present_ammount)
      list.add(ammount);

    return list.hashCode();
  }

  @Override
  public int compareTo(TIncrement other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetTable()).compareTo(other.isSetTable());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTable()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table, other.table);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetRow()).compareTo(other.isSetRow());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRow()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.row, other.row);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetColumn()).compareTo(other.isSetColumn());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumn()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.column, other.column);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAmmount()).compareTo(other.isSetAmmount());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAmmount()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ammount, other.ammount);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TIncrement(");
    boolean first = true;

    sb.append("table:");
    if (this.table == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.table, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("row:");
    if (this.row == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.row, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("column:");
    if (this.column == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.column, sb);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("ammount:");
    sb.append(this.ammount);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TIncrementStandardSchemeFactory implements SchemeFactory {
    public TIncrementStandardScheme getScheme() {
      return new TIncrementStandardScheme();
    }
  }

  private static class TIncrementStandardScheme extends StandardScheme<TIncrement> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TIncrement struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TABLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.table = iprot.readBinary();
              struct.setTableIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // ROW
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.row = iprot.readBinary();
              struct.setRowIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // COLUMN
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.column = iprot.readBinary();
              struct.setColumnIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // AMMOUNT
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.ammount = iprot.readI64();
              struct.setAmmountIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TIncrement struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.table != null) {
        oprot.writeFieldBegin(TABLE_FIELD_DESC);
        oprot.writeBinary(struct.table);
        oprot.writeFieldEnd();
      }
      if (struct.row != null) {
        oprot.writeFieldBegin(ROW_FIELD_DESC);
        oprot.writeBinary(struct.row);
        oprot.writeFieldEnd();
      }
      if (struct.column != null) {
        oprot.writeFieldBegin(COLUMN_FIELD_DESC);
        oprot.writeBinary(struct.column);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(AMMOUNT_FIELD_DESC);
      oprot.writeI64(struct.ammount);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TIncrementTupleSchemeFactory implements SchemeFactory {
    public TIncrementTupleScheme getScheme() {
      return new TIncrementTupleScheme();
    }
  }

  private static class TIncrementTupleScheme extends TupleScheme<TIncrement> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TIncrement struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetTable()) {
        optionals.set(0);
      }
      if (struct.isSetRow()) {
        optionals.set(1);
      }
      if (struct.isSetColumn()) {
        optionals.set(2);
      }
      if (struct.isSetAmmount()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetTable()) {
        oprot.writeBinary(struct.table);
      }
      if (struct.isSetRow()) {
        oprot.writeBinary(struct.row);
      }
      if (struct.isSetColumn()) {
        oprot.writeBinary(struct.column);
      }
      if (struct.isSetAmmount()) {
        oprot.writeI64(struct.ammount);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TIncrement struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.table = iprot.readBinary();
        struct.setTableIsSet(true);
      }
      if (incoming.get(1)) {
        struct.row = iprot.readBinary();
        struct.setRowIsSet(true);
      }
      if (incoming.get(2)) {
        struct.column = iprot.readBinary();
        struct.setColumnIsSet(true);
      }
      if (incoming.get(3)) {
        struct.ammount = iprot.readI64();
        struct.setAmmountIsSet(true);
      }
    }
  }

}

