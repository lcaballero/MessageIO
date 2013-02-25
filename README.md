# MessageIO

This is a java library that can map a file in of Message.g4 grammar to different target
code files.  The idea is that the target(s) may grow in number but they would all hold
to the interface published the mapping file.

## Example

Given a file like the one below it might produce a C# file matching the code that follows
the example.

```CSharp

version 1.0.0

service AddUser {
	inputs Id {
		int Id;
		string FirstName;
		string LastName;
	}
	outputs Id {
		int? Id;
		string FirstName;
		string LastName;
		int? AddressId;
		DateTime? DateOfBirth;
	}
}

```

```CSharp
// Version: 1.0.0
// Service: AddUser

namespace LucidEdge.SqlRequests
{
	{
		public int Id { get { return Map["Id"].ToValue<int>(); } }
		public string FirstName { get { return Map["FirstName"].ToValue<string>(); } }
		public string LastName { get { return Map["LastName"].ToValue<string>(); } }
	}

	public class AddUserOutputs : IDataMapping
	{
		public IDictionary<string,Datapoint>Map { get; set; }

		public int? Id { get { return Map["Id"].ToValue<int?>(); } }
		public string FirstName { get { return Map["FirstName"].ToValue<string>(); } }
		public string LastName { get { return Map["LastName"].ToValue<string>(); } }
		public int? AddressId { get { return Map["AddressId"].ToValue<int?>(); } }
		public DateTime? DateOfBirth { get { return Map["DateOfBirth"].ToValue<DateTime?>(); } }
	}
}
```

# TODO

1. Updated the project name to use ServiceIO instead of MessageIO
	1. Change the java namespace.
	1. Change the .bat paths.
	1. Change the file extension.
	1. Change the syntax highlighting extensions.
1. Change the attribute syntax to [Attr] and not [Attr1,Attr2] just incase
a future version might better use [Attr(p=v)].
1. Create a template that will transform the Service file into a table creation sql script.  Possibly also an insert row .sql script as well.

# Licesnse

LucidEdge.MessageIO and LucidEdge.Service are release under the MIT License.

Copyright 2013

Read the license here: http://opensource.org/license/MIT

Date: 2013-02-17
