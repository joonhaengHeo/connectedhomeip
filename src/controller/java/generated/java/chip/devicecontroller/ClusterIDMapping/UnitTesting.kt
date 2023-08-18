/*
 *
 *    Copyright (c) 2023 Project CHIP Authors
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package chip.devicecontroller.ClusterIDMapping

object UnitTesting : BaseCluster() {
  const val ID = 4294048773L

  sealed class Attribute(val id: Long, val name: String) {
    object Boolean : Attribute(0L, "Boolean")

    object Bitmap8 : Attribute(1L, "Bitmap8")

    object Bitmap16 : Attribute(2L, "Bitmap16")

    object Bitmap32 : Attribute(3L, "Bitmap32")

    object Bitmap64 : Attribute(4L, "Bitmap64")

    object Int8u : Attribute(5L, "Int8u")

    object Int16u : Attribute(6L, "Int16u")

    object Int24u : Attribute(7L, "Int24u")

    object Int32u : Attribute(8L, "Int32u")

    object Int40u : Attribute(9L, "Int40u")

    object Int48u : Attribute(10L, "Int48u")

    object Int56u : Attribute(11L, "Int56u")

    object Int64u : Attribute(12L, "Int64u")

    object Int8s : Attribute(13L, "Int8s")

    object Int16s : Attribute(14L, "Int16s")

    object Int24s : Attribute(15L, "Int24s")

    object Int32s : Attribute(16L, "Int32s")

    object Int40s : Attribute(17L, "Int40s")

    object Int48s : Attribute(18L, "Int48s")

    object Int56s : Attribute(19L, "Int56s")

    object Int64s : Attribute(20L, "Int64s")

    object Enum8 : Attribute(21L, "Enum8")

    object Enum16 : Attribute(22L, "Enum16")

    object FloatSingle : Attribute(23L, "FloatSingle")

    object FloatDouble : Attribute(24L, "FloatDouble")

    object OctetString : Attribute(25L, "OctetString")

    object ListInt8u : Attribute(26L, "ListInt8u")

    object ListOctetString : Attribute(27L, "ListOctetString")

    object ListStructOctetString : Attribute(28L, "ListStructOctetString")

    object LongOctetString : Attribute(29L, "LongOctetString")

    object CharString : Attribute(30L, "CharString")

    object LongCharString : Attribute(31L, "LongCharString")

    object EpochUs : Attribute(32L, "EpochUs")

    object EpochS : Attribute(33L, "EpochS")

    object VendorId : Attribute(34L, "VendorId")

    object ListNullablesAndOptionalsStruct : Attribute(35L, "ListNullablesAndOptionalsStruct")

    object EnumAttr : Attribute(36L, "EnumAttr")

    object StructAttr : Attribute(37L, "StructAttr")

    object RangeRestrictedInt8u : Attribute(38L, "RangeRestrictedInt8u")

    object RangeRestrictedInt8s : Attribute(39L, "RangeRestrictedInt8s")

    object RangeRestrictedInt16u : Attribute(40L, "RangeRestrictedInt16u")

    object RangeRestrictedInt16s : Attribute(41L, "RangeRestrictedInt16s")

    object ListLongOctetString : Attribute(42L, "ListLongOctetString")

    object ListFabricScoped : Attribute(43L, "ListFabricScoped")

    object TimedWriteBoolean : Attribute(48L, "TimedWriteBoolean")

    object GeneralErrorBoolean : Attribute(49L, "GeneralErrorBoolean")

    object ClusterErrorBoolean : Attribute(50L, "ClusterErrorBoolean")

    object Unsupported : Attribute(255L, "Unsupported")

    object NullableBoolean : Attribute(16384L, "NullableBoolean")

    object NullableBitmap8 : Attribute(16385L, "NullableBitmap8")

    object NullableBitmap16 : Attribute(16386L, "NullableBitmap16")

    object NullableBitmap32 : Attribute(16387L, "NullableBitmap32")

    object NullableBitmap64 : Attribute(16388L, "NullableBitmap64")

    object NullableInt8u : Attribute(16389L, "NullableInt8u")

    object NullableInt16u : Attribute(16390L, "NullableInt16u")

    object NullableInt24u : Attribute(16391L, "NullableInt24u")

    object NullableInt32u : Attribute(16392L, "NullableInt32u")

    object NullableInt40u : Attribute(16393L, "NullableInt40u")

    object NullableInt48u : Attribute(16394L, "NullableInt48u")

    object NullableInt56u : Attribute(16395L, "NullableInt56u")

    object NullableInt64u : Attribute(16396L, "NullableInt64u")

    object NullableInt8s : Attribute(16397L, "NullableInt8s")

    object NullableInt16s : Attribute(16398L, "NullableInt16s")

    object NullableInt24s : Attribute(16399L, "NullableInt24s")

    object NullableInt32s : Attribute(16400L, "NullableInt32s")

    object NullableInt40s : Attribute(16401L, "NullableInt40s")

    object NullableInt48s : Attribute(16402L, "NullableInt48s")

    object NullableInt56s : Attribute(16403L, "NullableInt56s")

    object NullableInt64s : Attribute(16404L, "NullableInt64s")

    object NullableEnum8 : Attribute(16405L, "NullableEnum8")

    object NullableEnum16 : Attribute(16406L, "NullableEnum16")

    object NullableFloatSingle : Attribute(16407L, "NullableFloatSingle")

    object NullableFloatDouble : Attribute(16408L, "NullableFloatDouble")

    object NullableOctetString : Attribute(16409L, "NullableOctetString")

    object NullableCharString : Attribute(16414L, "NullableCharString")

    object NullableEnumAttr : Attribute(16420L, "NullableEnumAttr")

    object NullableStruct : Attribute(16421L, "NullableStruct")

    object NullableRangeRestrictedInt8u : Attribute(16422L, "NullableRangeRestrictedInt8u")

    object NullableRangeRestrictedInt8s : Attribute(16423L, "NullableRangeRestrictedInt8s")

    object NullableRangeRestrictedInt16u : Attribute(16424L, "NullableRangeRestrictedInt16u")

    object NullableRangeRestrictedInt16s : Attribute(16425L, "NullableRangeRestrictedInt16s")

    object WriteOnlyInt8u : Attribute(16426L, "WriteOnlyInt8u")

    object GeneratedCommandList : Attribute(65528L, "GeneratedCommandList")

    object AcceptedCommandList : Attribute(65529L, "AcceptedCommandList")

    object EventList : Attribute(65530L, "EventList")

    object AttributeList : Attribute(65531L, "AttributeList")

    object FeatureMap : Attribute(65532L, "FeatureMap")

    object ClusterRevision : Attribute(65533L, "ClusterRevision")

    companion object {
      fun values(): List<Attribute> {
        return Attribute::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Long): Attribute {
        for (attribute in values()) {
          if (attribute.id == id) {
            return attribute
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): Attribute {
        for (attribute in values()) {
          if (attribute.name == value) {
            return attribute
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class Event(val id: Long, val name: String) {
    object TestEvent : Event(1L, "TestEvent")

    object TestFabricScopedEvent : Event(2L, "TestFabricScopedEvent")

    companion object {
      fun values(): List<Event> {
        return Event::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Long): Event {
        for (event in values()) {
          if (event.id == id) {
            return event
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): Event {
        for (event in values()) {
          if (event.name == value) {
            return event
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class Command(val id: Long, val name: String) {
    object Test : Command(0L, "Test")

    object TestNotHandled : Command(1L, "TestNotHandled")

    object TestSpecific : Command(2L, "TestSpecific")

    object TestUnknownCommand : Command(3L, "TestUnknownCommand")

    object TestAddArguments : Command(4L, "TestAddArguments")

    object TestSimpleArgumentRequest : Command(5L, "TestSimpleArgumentRequest")

    object TestStructArrayArgumentRequest : Command(6L, "TestStructArrayArgumentRequest")

    object TestStructArgumentRequest : Command(7L, "TestStructArgumentRequest")

    object TestNestedStructArgumentRequest : Command(8L, "TestNestedStructArgumentRequest")

    object TestListStructArgumentRequest : Command(9L, "TestListStructArgumentRequest")

    object TestListInt8UArgumentRequest : Command(10L, "TestListInt8UArgumentRequest")

    object TestNestedStructListArgumentRequest :
      Command(11L, "TestNestedStructListArgumentRequest")

    object TestListNestedStructListArgumentRequest :
      Command(12L, "TestListNestedStructListArgumentRequest")

    object TestListInt8UReverseRequest : Command(13L, "TestListInt8UReverseRequest")

    object TestEnumsRequest : Command(14L, "TestEnumsRequest")

    object TestNullableOptionalRequest : Command(15L, "TestNullableOptionalRequest")

    object TestComplexNullableOptionalRequest : Command(16L, "TestComplexNullableOptionalRequest")

    object SimpleStructEchoRequest : Command(17L, "SimpleStructEchoRequest")

    object TimedInvokeRequest : Command(18L, "TimedInvokeRequest")

    object TestSimpleOptionalArgumentRequest : Command(19L, "TestSimpleOptionalArgumentRequest")

    object TestEmitTestEventRequest : Command(20L, "TestEmitTestEventRequest")

    object TestEmitTestFabricScopedEventRequest :
      Command(21L, "TestEmitTestFabricScopedEventRequest")

    companion object {
      fun values(): List<Command> {
        return Command::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Long): Command {
        for (command in values()) {
          if (command.id == id) {
            return command
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): Command {
        for (command in values()) {
          if (command.name == value) {
            return command
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestAddArgumentsCommandField(val id: Int, val name: String) {
    object Arg1 : TestAddArgumentsCommandField(0, "Arg1")

    object Arg2 : TestAddArgumentsCommandField(1, "Arg2")

    companion object {
      fun values(): List<TestAddArgumentsCommandField> {
        return TestAddArgumentsCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestAddArgumentsCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestAddArgumentsCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestSimpleArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestSimpleArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestSimpleArgumentRequestCommandField> {
        return TestSimpleArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestSimpleArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestSimpleArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestStructArrayArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestStructArrayArgumentRequestCommandField(0, "Arg1")

    object Arg2 : TestStructArrayArgumentRequestCommandField(1, "Arg2")

    object Arg3 : TestStructArrayArgumentRequestCommandField(2, "Arg3")

    object Arg4 : TestStructArrayArgumentRequestCommandField(3, "Arg4")

    object Arg5 : TestStructArrayArgumentRequestCommandField(4, "Arg5")

    object Arg6 : TestStructArrayArgumentRequestCommandField(5, "Arg6")

    companion object {
      fun values(): List<TestStructArrayArgumentRequestCommandField> {
        return TestStructArrayArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestStructArrayArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestStructArrayArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestStructArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestStructArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestStructArgumentRequestCommandField> {
        return TestStructArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestStructArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestStructArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestNestedStructArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestNestedStructArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestNestedStructArgumentRequestCommandField> {
        return TestNestedStructArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestNestedStructArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestNestedStructArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestListStructArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestListStructArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestListStructArgumentRequestCommandField> {
        return TestListStructArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestListStructArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestListStructArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestListInt8UArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestListInt8UArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestListInt8UArgumentRequestCommandField> {
        return TestListInt8UArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestListInt8UArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestListInt8UArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestNestedStructListArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestNestedStructListArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestNestedStructListArgumentRequestCommandField> {
        return TestNestedStructListArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestNestedStructListArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestNestedStructListArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestListNestedStructListArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestListNestedStructListArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestListNestedStructListArgumentRequestCommandField> {
        return TestListNestedStructListArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestListNestedStructListArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestListNestedStructListArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestListInt8UReverseRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestListInt8UReverseRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestListInt8UReverseRequestCommandField> {
        return TestListInt8UReverseRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestListInt8UReverseRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestListInt8UReverseRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestEnumsRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestEnumsRequestCommandField(0, "Arg1")

    object Arg2 : TestEnumsRequestCommandField(1, "Arg2")

    companion object {
      fun values(): List<TestEnumsRequestCommandField> {
        return TestEnumsRequestCommandField::class.sealedSubclasses.map { it.objectInstance!! }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestEnumsRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestEnumsRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestNullableOptionalRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestNullableOptionalRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestNullableOptionalRequestCommandField> {
        return TestNullableOptionalRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestNullableOptionalRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestNullableOptionalRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestComplexNullableOptionalRequestCommandField(val id: Int, val name: String) {
    object NullableInt : TestComplexNullableOptionalRequestCommandField(0, "NullableInt")

    object OptionalInt : TestComplexNullableOptionalRequestCommandField(1, "OptionalInt")

    object NullableOptionalInt :
      TestComplexNullableOptionalRequestCommandField(2, "NullableOptionalInt")

    object NullableString : TestComplexNullableOptionalRequestCommandField(3, "NullableString")

    object OptionalString : TestComplexNullableOptionalRequestCommandField(4, "OptionalString")

    object NullableOptionalString :
      TestComplexNullableOptionalRequestCommandField(5, "NullableOptionalString")

    object NullableStruct : TestComplexNullableOptionalRequestCommandField(6, "NullableStruct")

    object OptionalStruct : TestComplexNullableOptionalRequestCommandField(7, "OptionalStruct")

    object NullableOptionalStruct :
      TestComplexNullableOptionalRequestCommandField(8, "NullableOptionalStruct")

    object NullableList : TestComplexNullableOptionalRequestCommandField(9, "NullableList")

    object OptionalList : TestComplexNullableOptionalRequestCommandField(10, "OptionalList")

    object NullableOptionalList :
      TestComplexNullableOptionalRequestCommandField(11, "NullableOptionalList")

    companion object {
      fun values(): List<TestComplexNullableOptionalRequestCommandField> {
        return TestComplexNullableOptionalRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestComplexNullableOptionalRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestComplexNullableOptionalRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class SimpleStructEchoRequestCommandField(val id: Int, val name: String) {
    object Arg1 : SimpleStructEchoRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<SimpleStructEchoRequestCommandField> {
        return SimpleStructEchoRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): SimpleStructEchoRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): SimpleStructEchoRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestSimpleOptionalArgumentRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestSimpleOptionalArgumentRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestSimpleOptionalArgumentRequestCommandField> {
        return TestSimpleOptionalArgumentRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestSimpleOptionalArgumentRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestSimpleOptionalArgumentRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestEmitTestEventRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestEmitTestEventRequestCommandField(0, "Arg1")

    object Arg2 : TestEmitTestEventRequestCommandField(1, "Arg2")

    object Arg3 : TestEmitTestEventRequestCommandField(2, "Arg3")

    companion object {
      fun values(): List<TestEmitTestEventRequestCommandField> {
        return TestEmitTestEventRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestEmitTestEventRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestEmitTestEventRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  sealed class TestEmitTestFabricScopedEventRequestCommandField(val id: Int, val name: String) {
    object Arg1 : TestEmitTestFabricScopedEventRequestCommandField(0, "Arg1")

    companion object {
      fun values(): List<TestEmitTestFabricScopedEventRequestCommandField> {
        return TestEmitTestFabricScopedEventRequestCommandField::class.sealedSubclasses.map {
          it.objectInstance!!
        }
      }

      @Throws(NoSuchFieldError::class)
      fun value(id: Int): TestEmitTestFabricScopedEventRequestCommandField {
        for (field in values()) {
          if (field.id == id) {
            return field
          }
        }
        throw NoSuchFieldError()
      }

      @Throws(IllegalArgumentException::class)
      fun valueOf(value: String): TestEmitTestFabricScopedEventRequestCommandField {
        for (field in values()) {
          if (field.name == value) {
            return field
          }
        }
        throw IllegalArgumentException()
      }
    }
  }

  override fun getID(): Long {
    return ID
  }

  override fun getAttributeName(id: Long): String {
    return Attribute.value(id).toString()
  }

  override fun getEventName(id: Long): String {
    return Event.value(id).toString()
  }

  override fun getCommandName(id: Long): String {
    return Command.value(id).toString()
  }

  override fun getAttributeID(name: String): Long {
    return Attribute.valueOf(name).id
  }

  override fun getEventID(name: String): Long {
    return Event.valueOf(name).id
  }

  override fun getCommandID(name: String): Long {
    return Command.valueOf(name).id
  }
}
