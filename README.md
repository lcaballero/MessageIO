# MessageIO

This is a java library that can map a file in of Message.g4 grammar to different target
code files.  The idea is that the target(s) may grow in number but they would all hold
to the interface published the mapping file.

## Example

Given a file like the one below it might produce a C# file matching the code that follows
the example.

```CSharp
version 1.0.0

[Inputs]
[UserInfoService]
message UserProfileInputs {
	[Primary] int Id;
	string FirstName;
	string LastName;
}

[Outputs]
[UserInfoService]
message UserProfileOutputs {
	[Primary] int? Id;
	string FirstName;
	string LastName;
	int? AddressId;
	DateTime? DateOfBirth;
}
```

```CSharp
// Version: 1.0.0
// Service Call: 
// Application: 
// Port: 

namespace LucidEdge.SqlRequests
{
	// [Inputs]
	// [UserInfoService]
	public class Inputs : IParameterBuilder
	{
		// [Primary]
		public int Id { get; set; }
		public string FirstName { get; set; }
		public string LastName { get; set; }

		public new List<DataPoint> ToParameters()
		{
			return
			new List<DataPoint>
			{
				new DataPoint("Id", Id),
				new DataPoint("FirstName", FirstName),
				new DataPoint("LastName", LastName)
			};
		}
	}
	// [Outputs]
	// [UserInfoService]
	public class Inputs : IParameterBuilder
	{
		// [Primary]
		public int? Id { get; set; }
		public string FirstName { get; set; }
		public string LastName { get; set; }
		public int? AddressId { get; set; }
		public DateTime? DateOfBirth { get; set; }

		public new List<DataPoint> ToParameters()
		{
			return
			new List<DataPoint>
			{
				new DataPoint("Id", Id),
				new DataPoint("FirstName", FirstName),
				new DataPoint("LastName", LastName),
				new DataPoint("AddressId", AddressId),
				new DataPoint("DateOfBirth", DateOfBirth)
			};
		}
	}


}
```


```SQL
-- Version: 1.0.0
-- Service Call: 
-- Application: 
-- Port: 

CREATE TABLE  (
	Id int,
	FirstName string,
	LastName string
);
CREATE TABLE  (
	Id int?,
	FirstName string,
	LastName string,
	AddressId int?,
	DateOfBirth DateTime?
);
```

# TODO

1. Updated the project name to use ServiceIO instead of MessageIO
	1. Change the java namespace.
	1. Change the .bat paths.
	1. Change the file extension.
	1. Change the syntax highlighting extensions.
1. Create a template that will transform the Service file into a table creation sql script.  Possibly also an insert row .sql script as well.


# DONE
1. [DONE] Change the attribute syntax to [Attr] and not [Attr1,Attr2] just incase
a future version might better use [Attr(p=v)].


# Licesnse

LucidEdge.MessageIO and LucidEdge.Service are release under the MIT License.

Copyright 2013

Read the license here: http://opensource.org/license/MIT

Date: 2013-02-17
