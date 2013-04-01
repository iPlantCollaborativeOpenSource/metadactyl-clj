# Table of Contents

* [App Editing Services](#app-editing-services)
    * [Making an Analysis Available for Editing in Tito](#making-an-analysis-available-for-editing-in-tito)
    * [Making a Copy of an Analysis Available for Editing in Tito](#making-a-copy-of-an-analysis-available-for-editing-in-tito)
    * [Submitting an Analysis for Public Use](#submitting-an-analysis-for-public-use)

# App Editing Services

## Making an Analysis Available for Editing in Tito

*Secured Endpoint:* GET /secured/edit-template/{analysis-id}

Tito uses this service to obtain the analysis description JSON so that the
analysis can be edited. The Analysis must have been integrated by the requesting
user, and it must not already be public. Currently, Analyses with more than 1
step can not be edited.

The response body contains the analysis description in the format that is
required by Tito. Here's an example:

```
$ curl -s "http://by-tor:8888/secured/edit-template/F29C156C-E286-4BBD-9033-0075C09E0D70?user=snow-dog&email=sd@example.org" | python -mjson.tool
{
    "objects": [
        {
            "component": "cat",
            "component_id": "c72c314d1eace461290b9b568d9feb86a",
            "description": "",
            "edited_date": "",
            "groups": {
                "description": "",
                "groups": [
                    {
                        "description": "",
                        "id": "524AD6B2-7093-A9E6-1F56-919C09E286F9",
                        "isVisible": true,
                        "label": "Advanced Arguments",
                        "name": "",
                        "properties": [
                            {
                                "description": "",
                                "id": "37ADF623-36AD-31A1-3455-4F95F2108774",
                                "isVisible": true,
                                "label": "Advanced Options",
                                "name": "",
                                "omit_if_blank": false,
                                "order": -1,
                                "type": "Info",
                                "value": ""
                            },
                            {
                                "description": "This is an example of tool tip text that might be helpful ",
                                "id": "A391A212-8261-3662-A812-68E5309D3A5A",
                                "isVisible": true,
                                "label": "Number blank lines",
                                "name": "-b",
                                "omit_if_blank": false,
                                "order": -1,
                                "type": "Flag",
                                "value": "false"
                            }
                        ],
                        "type": ""
                    },
                    {
                        "description": "",
                        "id": "4CC29EF5-E950-5177-B54A-C61C33637BD4",
                        "isVisible": true,
                        "label": "This is a group mechanism",
                        "name": "",
                        "properties": [
                            {
                                "description": "",
                                "id": "23ABF631-8109-D3FA-0714-2378059BBBA1",
                                "isVisible": true,
                                "label": "Another argument",
                                "name": "-e",
                                "omit_if_blank": false,
                                "order": -1,
                                "type": "Flag",
                                "value": "false"
                            }
                        ],
                        "type": ""
                    }
                ],
                "id": "--root-PropertyGroupContainer--",
                "isVisible": true,
                "label": "",
                "name": ""
            },
            "id": "F29C156C-E286-4BBD-9033-0075C09E0D70",
            "label": "Sample Cat",
            "name": "Sample Cat",
            "published_date": "",
            "references": [],
            "tito": "F29C156C-E286-4BBD-9033-0075C09E0D70",
            "type": ""
        }
    ]
}
```

## Making a Copy of an Analysis Available for Editing in Tito

*Secured Endpoint:* GET /secured/copy-template/{analysis-id}

This service can be used to make a copy of an analysis in the user's workspace.
The response body consists of a JSON object containing the ID of the new
analysis. Here's an example:

Here's an example:

```
$ curl -s "http://by-tor:8888/secured/copy-template/C720C42D-531A-164B-38CC-D2D6A337C5A5?user=snow-dog&email=sd@example.org" | python -m json.tool
{
    "analysis_id": "13FF6D0C-F6F7-4ACE-A6C7-635A17826383"
}
```

## Submitting an Analysis for Public Use

*Secured Endpoint:* POST /secured/make-analysis-public

This service can be used to submit a private analysis for public use. The user
supplies basic information about the analysis and a suggested location for it.
The service records the information and suggested location then places the
analysis in the Beta category. A Tito administrator can subsequently move the
analysis to the suggested location at a later time if it proves to be useful.
The request body is in the following format:

```json
{
    "analysis_id": "analysis-id",
    "email": "integrator-email-address",
    "integrator": "integrator-name",
    "references": [
        "reference-link-1",
        "reference-link-2",
        ...,
        "reference-link-n"
    ],
    "groups": [
        "suggested-group-1",
        "suggested-group-2",
        ...,
        "suggested-group-n"
    ],
    "desc": "analysis-description",
    "wiki_url": "documentation-link"
}
```

The response body is just an empty JSON object if the service call succeeds.

Making an analysis public entails recording the additional inforamtion provided
to the service, removing the analysis from all of its current analysis groups,
adding the analysis to the _Beta_ group.

Here's an example:

```
$ curl -sd '
{
    "analysis_id": "F771A215-4809-4683-87C0-A899C0732AF3",
    "email": "nobody@iplantcollaborative.org",
    "integrator": "Nobody",
    "references": [
        "http://foo.bar.baz.org"
    ],
    "groups": [
        "0A687324-099B-4EEF-A82C-C1A60B970487"
    ],
    "desc": "The foo is in the bar.",
    "wiki_url": "https://wiki.iplantcollaborative.org/docs/Foo+Foo"
}
' "http://by-tor:8888/secured/make-analysis-public?user=snow-dog&email=sd@example.org"
{}
```